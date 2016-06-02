package com.myf.fangjuejing.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myf.fangjuejing.R;
import com.myf.fangjuejing.WebViewEntryActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by MaoYouFeng on 2016/5/31.
 */
public class NormalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mContext;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_hot_new, parent, false);
        mContext=v.getContext();
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
        @OnClick(R.id.card)
        public void showWebView(){
            WebViewEntryActivity.startActivity(mContext);
        }
    }
}