package com.myf.fangjuejing.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.LinearLayout;

import com.myf.fangjuejing.R;
import com.myf.fangjuejing.fragment.CommonFragment;
import com.myf.fangjuejing.fragment.HomeFragment;
import com.myf.fangjuejing.fragment.NormalFragment;

import java.util.HashMap;

import butterknife.Bind;

/**
 * Created by MaoYouFeng on 2016/5/31.
 */
public class TabsAdapter extends FragmentPagerAdapter {

    String[] tabs=new String[]{};
    public static  int LIST=0;
    public static  int NO_DATA=1;
    private int fragment_type;
    public TabsAdapter(FragmentManager fm, String[] tabs,int fragment_type) {
        super(fm);
        this.tabs = tabs;
        this.fragment_type=fragment_type;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    public void update(String[] tabs){
        this.tabs=tabs;
        notifyDataSetChanged();
    }
    @Override
    public Fragment getItem(int position) {
        if(fragment_type==LIST)
            return NormalFragment.newInstance();
        else{
            return CommonFragment.newInstance(position);
        }
    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}
