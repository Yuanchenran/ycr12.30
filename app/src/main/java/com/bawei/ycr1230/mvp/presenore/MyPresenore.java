package com.bawei.ycr1230.mvp.presenore;

import com.bawei.ycr1230.NetUlit;
import com.bawei.ycr1230.mvp.MyModel.MyModel;
import com.bawei.ycr1230.mvp.view.MyView;

public class MyPresenore {
    private MyView myView;
    private MyModel myModel;

    public MyPresenore(MyView myView) {
        this.myView = myView;
        myModel=new MyModel();
    }
    public void listData(String path){
        myModel.listData(path, new NetUlit.CallBack() {
            @Override
            public void jsonOk(String json) {
                myView.jsonOk(json);
            }

            @Override
            public void jsonNo(String msg) {
                  myView.jsonNo(msg);
            }
        });
    }
}
