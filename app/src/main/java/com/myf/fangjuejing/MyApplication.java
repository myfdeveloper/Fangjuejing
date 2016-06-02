package com.myf.fangjuejing;

import android.app.Application;

/**
 * Created by MaoYouFeng on 2016/5/30.
 */
public class MyApplication extends Application{
    private static MyApplication app;
    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
    }
    public static MyApplication app(){
        return app;
    }
}
