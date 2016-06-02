package com.myf.fangjuejing.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.myf.fangjuejing.R;
import com.myf.fangjuejing.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by MaoYouFeng on 2016/5/31.
 */
public class CommonFragment extends BaseFragment {
    public static CommonFragment newInstance(int curpage) {
        CommonFragment mFragment = new CommonFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("curpage", curpage);
        mFragment.setArguments(bundle);
        return mFragment;
    }

    @Override
    protected int initContentView() {
        return R.layout.fragment_no_data;
    }

    @Bind(R.id.no_attention)
    LinearLayout no_attention;
    @Bind(R.id.iv_attention)
    ImageView iv_attention;
    @Bind(R.id.tv_attention_tips)
    TextView tv_attention_tips;
    @Bind(R.id.bt_attention_pay)
    TextView bt_attention_pay;

    @Override
    protected void initUI(View view) {
        ButterKnife.bind(this, view);
        int curpage= (int) getArguments().get("curpage");
        no_attention.setVisibility(View.VISIBLE);
        if(curpage==0){
            iv_attention.setImageResource(R.mipmap.user_notify_no_data);
            tv_attention_tips.setText("暂时没有任何消息哦\n去评论区和小伴们互动起来吧~");
            bt_attention_pay.setVisibility(View.GONE);
        }else{
            iv_attention.setVisibility(View.GONE);
            tv_attention_tips.setText("你没有任何动态哦");
            bt_attention_pay.setVisibility(View.VISIBLE);

        }
    }

    @Override
    protected void destroy() {
        ButterKnife.unbind(this);
    }
}
