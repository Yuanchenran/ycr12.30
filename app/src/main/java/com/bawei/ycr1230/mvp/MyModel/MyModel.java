package com.bawei.ycr1230.mvp.MyModel;

import com.bawei.ycr1230.NetUlit;

public class MyModel {
    public void listData(String path, final NetUlit.CallBack callBack){
        NetUlit netUlit = NetUlit.getNetUlit();
        netUlit.doGet(path, new NetUlit.CallBack() {
            @Override
            public void jsonOk(String json) {
              callBack.jsonOk(json);
            }

            @Override
            public void jsonNo(String msg) {
             callBack.jsonNo(msg);
            }
        });
    }
}
