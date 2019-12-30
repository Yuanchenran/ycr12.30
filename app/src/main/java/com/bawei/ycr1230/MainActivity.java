package com.bawei.ycr1230;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bawei.ycr1230.adapter.MyPagerAdapter;
import com.bawei.ycr1230.base.BaseActivity;
import com.bawei.ycr1230.mvp.view.MyView;

public class MainActivity extends BaseActivity  {


    private android.support.v4.view.ViewPager vp;
    private android.support.design.widget.TabLayout tab;

    @Override
    protected int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        vp = (ViewPager) findViewById(R.id.vp);
        tab = (TabLayout) findViewById(R.id.tab);
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(myPagerAdapter);
        tab.setupWithViewPager(vp);
        tab.setTabTextColors(Color.RED,Color.BLUE);
        tab.setSelectedTabIndicatorColor(Color.YELLOW);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
    public void toItem(int prosoner){
        vp.setCurrentItem(prosoner);
    }
}
