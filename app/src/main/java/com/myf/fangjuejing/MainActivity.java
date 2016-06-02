package com.myf.fangjuejing;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.myf.fangjuejing.base.BaseActivity;
import com.myf.fangjuejing.fragment.ContentFragment;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    public static void startActivity(Context mContext) {
        Intent intent = new Intent(mContext, MainActivity.class);
        mContext.startActivity(intent);
    }

    @Override
    protected void initUiAndListener() {
        ButterKnife.bind(this);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, ContentFragment.newInstance())
                .commit();
    }

    @Override
    protected int initContentView() {
        return R.layout.activity_main;
    }
}
