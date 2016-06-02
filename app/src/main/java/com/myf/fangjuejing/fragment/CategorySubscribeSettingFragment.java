package com.myf.fangjuejing.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.myf.fangjuejing.R;
import com.myf.fangjuejing.adapter.CategoryAdapter;
import com.myf.fangjuejing.base.BaseFragment;
import com.myf.fangjuejing.bean.Category;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by MaoYouFeng on 2016/5/29.
 */
public class CategorySubscribeSettingFragment extends BaseFragment {

    public static CategorySubscribeSettingFragment newInstance() {
        return new CategorySubscribeSettingFragment();
    }

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @Override
    protected int initContentView() {
        return R.layout.base_list_layout;
    }

    @Override
    protected void initUI(View view) {
        ButterKnife.bind(this, view);
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(R.mipmap.ic_share_android, "Android"));
        categories.add(new Category(R.mipmap.ic_share_frontend, "前端"));
        categories.add(new Category(R.mipmap.ic_share_ios, "IOS"));
        categories.add(new Category(R.mipmap.ic_share_product, "产品"));
        categories.add(new Category(R.mipmap.ic_share_design, "设计"));
        categories.add(new Category(R.mipmap.ic_share_freebie, "工具"));
        categories.add(new Category(R.mipmap.ic_share_article, "阅读"));
        categories.add(new Category(R.mipmap.ic_share_backend, "后端"));
        CategoryAdapter adapter = new CategoryAdapter(this.getContext(),categories);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void destroy() {
        ButterKnife.unbind(this);
    }
}
