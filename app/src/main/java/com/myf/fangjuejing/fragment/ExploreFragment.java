package com.myf.fangjuejing.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.myf.PagerSlidingTabStripEx;
import com.myf.fangjuejing.R;
import com.myf.fangjuejing.adapter.TabsAdapter;
import com.myf.fangjuejing.base.BaseFragment;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by MaoYouFeng on 2016/5/28.
 */
public class ExploreFragment extends BaseFragment {

    public static ExploreFragment newInstance(){
        return new ExploreFragment();
    }
    @Override
    protected int initContentView() {
        return R.layout.fragment_explore;
    }

    @Bind(R.id.tabs)
    PagerSlidingTabStripEx tabs;
    @Bind(R.id.viewpager_child)
    ViewPager pager;

    TabsAdapter adapter;
    @Override
    protected void initUI(View view) {
        ButterKnife.bind(this,view);
        adapter=new TabsAdapter(getChildFragmentManager(),new String[]{"热门","最新"},TabsAdapter.LIST);
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
    }

    @Override
    protected void destroy() {
        ButterKnife.unbind(this);
    }

}
