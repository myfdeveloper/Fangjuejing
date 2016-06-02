package com.myf.fangjuejing.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myf.fangjuejing.R;
import com.myf.fangjuejing.adapter.NormalAdapter;
import com.myf.fangjuejing.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by MaoYouFeng on 2016/5/30.
 */
public class NormalFragment extends BaseFragment {

    public static NormalFragment newInstance(){
        return new NormalFragment();
    }
    @Override
    protected int initContentView() {
        return R.layout.fragment_content;
    }

    @Bind(R.id.recyclerview_content)
    RecyclerView mRecyclerView;
    @Bind(R.id.pager_page)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void initUI(View view) {
        ButterKnife.bind(this, view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new NormalAdapter());
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    @Override
    protected void destroy() {
        ButterKnife.unbind(this);
    }
}
