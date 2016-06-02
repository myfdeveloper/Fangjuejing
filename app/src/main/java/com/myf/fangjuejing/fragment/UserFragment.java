package com.myf.fangjuejing.fragment;

import android.view.View;

import com.myf.fangjuejing.R;
import com.myf.fangjuejing.SettingActivity;
import com.myf.fangjuejing.UserNormalHomePageActivity;
import com.myf.fangjuejing.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by MaoYouFeng on 2016/5/28.
 */
public class UserFragment extends BaseFragment {

    public static UserFragment newInstance(){
        return new UserFragment();
    }
    @Override
    protected int initContentView() {
        return R.layout.fragment_user;
    }

    @OnClick(R.id.layout_user_info)
    public void enterUserInfo(){
        UserNormalHomePageActivity.startActivity(getContext());
    }
    @OnClick(R.id.layout_setting)
    public void enterSetting(){
        SettingActivity.startActivity(getContext());
    }

    @Override
    protected void initUI(View view) {
        ButterKnife.bind(this,view);
    }

    @Override
    protected void destroy() {
        ButterKnife.unbind(this);
    }
}
