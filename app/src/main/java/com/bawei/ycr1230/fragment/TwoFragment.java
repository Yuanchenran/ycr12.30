package com.bawei.ycr1230.fragment;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.bawei.ycr1230.Bean.MyBean;
import com.bawei.ycr1230.Bean.MyShopGridData;
import com.bawei.ycr1230.MainActivity;
import com.bawei.ycr1230.R;
import com.bawei.ycr1230.adapter.MyGridAdapter;
import com.bawei.ycr1230.base.BaseFragment;
import com.bawei.ycr1230.mvp.presenore.MyPresenore;
import com.bawei.ycr1230.mvp.view.MyView;
import com.google.gson.Gson;

import java.util.List;

public class TwoFragment extends BaseFragment implements MyView {
    private android.widget.Button btn;
    private android.widget.GridView gv;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_two;
    }

    @Override
    protected void initView() {

        btn = (Button)rootView. findViewById(R.id.btn);
        gv = (GridView) rootView.findViewById(R.id.gv);
    }

    @Override
    protected void initListener() {
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               MainActivity activity = (MainActivity) getActivity();
               activity.toItem(0);

           }
       });
    }

    @Override
    protected void initData() {
        String path="http://blog.zhaoliang5156.cn/api/mall/mall.json";
        MyPresenore myPresenore = new MyPresenore(this);
        myPresenore.listData(path);
    }

    @Override
    public void jsonOk(String json) {
        Gson gson = new Gson();
        MyBean myBean = gson.fromJson(json, MyBean.class);
        List<MyShopGridData> shopGridData = myBean.getShopGridData();
        MyGridAdapter myGridAdapter = new MyGridAdapter(shopGridData, getContext());
        gv.setAdapter(myGridAdapter);
    }

    @Override
    public void jsonNo(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
