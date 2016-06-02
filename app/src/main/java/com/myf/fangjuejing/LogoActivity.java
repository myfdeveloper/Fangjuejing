package com.myf.fangjuejing;

import android.text.TextUtils;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.myf.fangjuejing.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by MaoYouFeng on 2016/5/28.
 */
public class LogoActivity extends BaseActivity {

    @Bind(R.id.splash)
    RelativeLayout splash;

    @Override
    protected void initUiAndListener() {
        ButterKnife.bind(this);
        AlphaAnimation aa = new AlphaAnimation(0.7f, 1.0f);
        aa.setDuration(2000);
        splash.startAnimation(aa);
        aa.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                MainActivity.startActivity(LogoActivity.this);
                String action = getIntent().getAction();
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    protected int initContentView() {
        return R.layout.activity_logo;
    }
}
