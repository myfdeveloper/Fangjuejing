package com.myf.fangjuejing.fragment;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.astuetz.PagerSlidingTabStrip;
import com.myf.fangjuejing.R;
import com.myf.fangjuejing.base.BaseFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by MaoYouFeng on 2016/5/28.
 */
public class ContentFragment extends BaseFragment {

    public static ContentFragment newInstance() {
        ContentFragment mFragment = new ContentFragment();
        return mFragment;
    }

    @Override
    protected int initContentView() {
        return R.layout.fragment_tabs;
    }

    @Bind(R.id.pager)
    ViewPager pager;

    @Bind(R.id.tabs)
    SmartTabLayout tabs;

    @Override
    protected void initUI(View view) {
        ButterKnife.bind(this, view);
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(MainFragment.newInstance());
        fragmentList.add(ExploreFragment.newInstance());
        fragmentList.add(NotifyFragment.newInstance());
        fragmentList.add(UserFragment.newInstance());
        List<Integer> drawables = new ArrayList<>();
        drawables.add(R.drawable.tab_home_main);
        drawables.add(R.drawable.tab_home_find);
        drawables.add(R.drawable.tab_home_notifications);
        drawables.add(R.drawable.tab_home_profile);
        MyAdapter adapter=new MyAdapter(getActivity().getSupportFragmentManager(), fragmentList, drawables);
        pager.setAdapter(adapter);
        tabs.setCustomTabView(adapter);
        tabs.setViewPager(pager);
    }

    @Override
    protected void destroy() {
        ButterKnife.unbind(this);
    }

    class MyAdapter extends FragmentPagerAdapter implements SmartTabLayout.TabProvider {
        final LayoutInflater inflater = LayoutInflater.from(getContext());
        List<Fragment> fragmentList;
        List<Integer> drawables;

        public MyAdapter(FragmentManager fm, List<Fragment> fragmentList, List<Integer> drawables) {
            super(fm);
            this.fragmentList = fragmentList;
            this.drawables = drawables;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
            ImageView icon = (ImageView) inflater.inflate(R.layout.custom_tab_icon, container,
                    false);
            icon.setImageResource(drawables.get(position));
            return icon;
        }
    }
}
