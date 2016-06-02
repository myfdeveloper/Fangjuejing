package com.myf.fangjuejing.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.myf.PagerSlidingTabStripEx;
import com.myf.fangjuejing.fragment.CommonFragment;
import com.myf.fangjuejing.fragment.NormalFragment;

/**
 * Created by MaoYouFeng on 2016/5/31.
 */
public class UserAdapter extends FragmentPagerAdapter {


    String[] tabs=new String[]{"菜单","分享","收藏","关注","关注者"};

    private int fragment_type;
    public UserAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public Fragment getItem(int position) {
            return NormalFragment.newInstance();
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

}
