package com.myf.fangjuejing.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;
import com.myf.PagerSlidingTabStripEx;
import com.myf.fangjuejing.CommonActivity;
import com.myf.fangjuejing.R;
import com.myf.fangjuejing.base.BaseFragment;
import com.myf.fangjuejing.helper.SharePrefHelper;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by MaoYouFeng on 2016/5/28.
 */
public class MainFragment extends BaseFragment {

    public static MainFragment newInstance(){
        return new MainFragment();
    }
    @Override
    protected int initContentView() {
        return R.layout.fragment_main;
    }

    @Bind(R.id.tabs)
    PagerSlidingTabStripEx tabs;
    @Bind(R.id.viewpager_child)
    ViewPager pager;

    HashMap<String, String> categorys=new HashMap<>();
    MyAdapter adapter;
    @Override
    protected void initUI(View view) {
        ButterKnife.bind(this,view);
        EventBus.getDefault().register(this);

        if(!SharePrefHelper.getFirstCatagoryKey().isEmpty()){
            categorys.put(SharePrefHelper.getFirstCatagoryKey(),SharePrefHelper.getFirstCatagoryValue());
        }
        if(!SharePrefHelper.getSecondCatagoryKey().isEmpty()){
            categorys.put(SharePrefHelper.getSecondCatagoryKey(),SharePrefHelper.getSecondCatagoryValue());
        }
        adapter=new MyAdapter(getChildFragmentManager(),categorys);
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
    }


    @OnClick(R.id.iv_category)
    public void selCategory(){
        CommonActivity.startActivity(getContext(),"category");
    }

    @Subscribe
    public void catagoryChange(HashMap<String, String> categorys){
        this.categorys=categorys;
        System.out.println("categorys-->"+categorys.size());
        adapter.update(categorys);
        tabs.setViewPager(pager);
        tabs.refreshDrawableState();
    }

    @Override
    protected void destroy() {
        ButterKnife.unbind(this);
        EventBus.getDefault().unregister(this);
    }

    class MyAdapter extends FragmentPagerAdapter{

        HashMap<String, String> categorys;

        public MyAdapter(FragmentManager fm, HashMap<String, String> categorys) {
            super(fm);
            this.categorys = categorys;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position==0)
                return "首页";
            return (CharSequence) categorys.values().toArray()[position-1];
        }

        public void update(HashMap<String, String> categorys){
            this.categorys=categorys;
            notifyDataSetChanged();
        }
        @Override
        public Fragment getItem(int position) {
            if(position==0)
                return HomeFragment.newInstance();
            return NormalFragment.newInstance();
        }

        @Override
        public int getCount() {
            return categorys.size()+1;
        }
    }

}
