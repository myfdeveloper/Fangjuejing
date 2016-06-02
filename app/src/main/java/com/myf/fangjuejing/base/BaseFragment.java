package com.myf.fangjuejing.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.myf.fangjuejing.R;

/**
 * Created by MaoYouFeng on 2016/5/28.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup main = (ViewGroup) inflater.inflate(initContentView(), container, false);

        return main;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //onViewCreated在onCreateView执行完后立即执行。
        initUI(view);
        super.onViewCreated(view, savedInstanceState);
    }

    protected abstract int initContentView();

    protected abstract void initUI(View view);

    protected abstract void destroy();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        destroy();
    }
}
