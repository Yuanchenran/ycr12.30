package com.bawei.ycr1230;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetUlit {
   private static  NetUlit netUlit;
   private final RequestQueue requestQueue;
    private NetworkInfo activeNetworkInfo;

    private NetUlit() {
        requestQueue = Volley.newRequestQueue(App.context);
    }

    public static NetUlit getNetUlit() {
        if (netUlit == null) {
            synchronized (NetUlit.class){
                if (netUlit == null) {
                    netUlit=new NetUlit();
                }
            }
        }
        return netUlit;
    }
    //判断网络状态的方法
    public Boolean isplings(){
    ConnectivityManager connectivityManager= (ConnectivityManager) App.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo!=null){
            return true;
        }
        return false;
    }
    public void doGet(final String path, final CallBack callBack){
        Boolean isplings = isplings();
        if (!isplings) {
            return;
        }
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... strings) {
                try {
                    URL url = new URL(path);
                    HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(8000);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode==200){
                        InputStream inputStream = httpURLConnection.getInputStream();
                        int len=-1;
                        byte[] bytes = new byte[1024];
                        StringBuffer stringBuffer = new StringBuffer();
                        while ((len=inputStream.read(bytes))!=-1){
                            stringBuffer.append(new String(bytes,0,len));
                        }
                        String json = stringBuffer.toString();
                        inputStream.close();
                        return json;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if (s != null) {
                    if (callBack != null) {
                        callBack.jsonOk(s);
                    }
                }else {
                    callBack.jsonNo("无法连接网络，请检查网络并刷新重试");
                }

            }
        }.execute();


    }
    //图片请求
    public void doPoson(String path, ImageView imageView){
        Glide.with(App.context)
                .load(path)
                .into(imageView);
    }


    public  interface CallBack{
        void jsonOk(String json);
        void jsonNo(String msg);
    }
}
