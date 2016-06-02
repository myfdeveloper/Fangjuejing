package com.myf.fangjuejing.helper;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.myf.fangjuejing.MyApplication;

/**
 * Created by MaoYouFeng on 2016/5/30.
 */
public class SharePrefHelper {

    public static void setFirstCatagory(String key, String value) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.app());
        prefs.edit().putString("sp_home_first_name", key)
                .putString("sp_home_first_title", value)
                .apply();
    }

    public static void delCatagory(int index) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.app());
        if (index == 0)
            prefs.edit().remove("sp_home_first_name").remove("sp_home_first_title").apply();
        else
            prefs.edit().remove("sp_home_second_name").remove("sp_home_second_title").apply();
    }


    public static void setSecondCatagory(String key, String value) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.app());
        prefs.edit().putString("sp_home_second_name", key)
                .putString("sp_home_second_title", value)
                .apply();
    }

    public static String getFirstCatagoryKey() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.app());
        return prefs.getString("sp_home_first_name", "");
    }

    public static String getFirstCatagoryValue() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.app());
        return prefs.getString("sp_home_first_title", "");
    }

    public static String getSecondCatagoryKey() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.app());
        return prefs.getString("sp_home_second_name", "");
    }

    public static String getSecondCatagoryValue() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.app());
        return prefs.getString("sp_home_second_title", "");
    }
}
