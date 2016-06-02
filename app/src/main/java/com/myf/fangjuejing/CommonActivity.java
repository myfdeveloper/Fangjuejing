package com.myf.fangjuejing;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;

import com.myf.fangjuejing.base.BaseActivity;
import com.myf.fangjuejing.fragment.CategorySubscribeSettingFragment;
import com.myf.fangjuejing.fragment.ContentFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by MaoYouFeng on 2016/5/29.
 */
public class CommonActivity extends BaseActivity {

    public static void startActivity(Context mContext, String type) {
        Intent intent = new Intent(mContext, CommonActivity.class);
        intent.putExtra(type, true);
        mContext.startActivity(intent);
    }

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    public static void startActivity(Context mContext, Fragment fragment, String type) {
        Intent intent = new Intent(mContext, MainActivity.class);
        mContext.startActivity(intent);
    }

    @Override
    protected void initUiAndListener() {
        ButterKnife.bind(this);
        initToolBar(toolbar);
        setTitle("");
        if (getIntent().hasExtra("category")) {
            setTitle("首页特别展示");
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content, CategorySubscribeSettingFragment.newInstance())
                    .commit();
        }

    }

    public void initToolBar(Toolbar mToolBar) {
        if (null != mToolBar) {
            setSupportActionBar(mToolBar);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    protected int initContentView() {
        return R.layout.base_content_toolbar_layout;
    }

}
