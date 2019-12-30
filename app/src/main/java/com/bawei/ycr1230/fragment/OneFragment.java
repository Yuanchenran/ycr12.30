package com.bawei.ycr1230.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.bawei.ycr1230.NetUlit;
import com.bawei.ycr1230.R;
import com.bawei.ycr1230.base.BaseFragment;

public class OneFragment extends BaseFragment {
    private android.widget.TextView title;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_one;
    }

    @Override
    protected void initView() {

        title = (TextView)rootView. findViewById(R.id.title);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        String titles = arguments.getString("title");
        int id = arguments.getInt("id");
        if (id==0){
            NetUlit netUlit = NetUlit.getNetUlit();
            Boolean isplings = netUlit.isplings();
            if (!isplings) {
                title.setText("无法连接网络，请检查网络并刷新重试");
            }else {
                title.setText(titles);
            }
        }else {
            title.setText(titles);
        }


    }
}
