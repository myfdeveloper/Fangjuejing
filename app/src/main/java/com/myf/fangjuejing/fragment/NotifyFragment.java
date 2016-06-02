package com.myf.fangjuejing.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.myf.PagerSlidingTabStripEx;
import com.myf.fangjuejing.R;
import com.myf.fangjuejing.adapter.TabsAdapter;
import com.myf.fangjuejing.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by MaoYouFeng on 2016/5/28.
 */
public class NotifyFragment extends BaseFragment {

    public static NotifyFragment newInstance(){
        return new NotifyFragment();
    }
    @Override
    protected int initContentView() {
        return R.layout.fragment_notify;
    }

    @Bind(R.id.tabs)
    PagerSlidingTabStripEx tabs;
    @Bind(R.id.viewpager_child)
    ViewPager pager;

    TabsAdapter adapter;
    @Override
    protected void initUI(View view) {
        ButterKnife.bind(this,view);
        adapter=new TabsAdapter(getChildFragmentManager(),new String[]{"消息","动态"},TabsAdapter.NO_DATA);
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
    }
    @Override
    protected void destroy() {
        ButterKnife.unbind(this);
    }
}
