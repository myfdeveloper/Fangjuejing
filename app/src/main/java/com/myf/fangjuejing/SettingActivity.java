package com.myf.fangjuejing;

import android.content.Context;
import android.content.Intent;

import com.myf.fangjuejing.base.BaseActivity;

/**
 * Created by MaoYouFeng on 2016/6/1.
 */
public class SettingActivity extends BaseActivity {
    public static void startActivity(Context context){
        context.startActivity(new Intent(context,SettingActivity.class));
    }
    @Override
    protected void initUiAndListener() {

    }

    @Override
    protected int initContentView() {
        return R.layout.settings_activity;
    }
}
