package com.bawei.ycr1230.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bawei.ycr1230.fragment.OneFragment;
import com.bawei.ycr1230.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

public class MyPagerAdapter extends FragmentPagerAdapter {
     private String[] strings={"首页","分类","发现","购物车","我的"};
     private List<Fragment> fragments=new ArrayList<>();

     public MyPagerAdapter(FragmentManager fm) {
        super(fm);
         for (int i = 0; i <strings.length; i++) {
             if (i==3){
                 TwoFragment twoFragment = new TwoFragment();
                 fragments.add(twoFragment);
             }else {
                 OneFragment oneFragment = new OneFragment();
                 String title = strings[i];
                 Bundle bundle = new Bundle();
                 bundle.putString("title",title);
                 bundle.putInt("id",i);
                 oneFragment.setArguments(bundle);

                 fragments.add(oneFragment);
             }
         }

    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return strings[position];
    }
}
