package com.myf.fangjuejing.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myf.fangjuejing.R;
import com.myf.fangjuejing.WebViewEntryActivity;
import com.myf.fangjuejing.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by MaoYouFeng on 2016/5/30.
 */
public class HomeFragment extends BaseFragment {

    public static HomeFragment newInstance(){
        return new HomeFragment();
    }
    @Override
    protected int initContentView() {
        return R.layout.fragment_content;
    }

    @Bind(R.id.recyclerview_content)
    RecyclerView mRecyclerView;
    @Bind(R.id.pager_page)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private boolean remove;
    @Override
    protected void initUI(View view) {
        ButterKnife.bind(this, view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new MyAdapter());
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    protected void destroy() {
        ButterKnife.unbind(this);
    }

    class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public static final int TYPE_HEADER = 0;
        public static final int TYPE_NORMAL = 1;

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if(viewType == TYPE_HEADER) {
                View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_entry_hot_recommend, parent, false);
                return new ViewHolderHeader(v);
            }else {
                View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.card_entry, parent, false);
                return new ViewHolder(v);
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if(getItemViewType(position)==TYPE_HEADER){
                ViewHolderHeader viewHolderHeader= (ViewHolderHeader) holder;
            }else{
                ViewHolder viewHolder= (ViewHolder) holder;
            }
        }

        @Override
        public int getItemViewType(int position) {
            if(position == 0 && !remove) return TYPE_HEADER;
            return TYPE_NORMAL;
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
            @OnClick(R.id.card_entry)
            public void showWebView(){
                System.out.println("card_entry");
                WebViewEntryActivity.startActivity(getContext());
            }
        }

        class ViewHolderHeader extends RecyclerView.ViewHolder {

            public ViewHolderHeader(View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);

            }

            @OnClick(R.id.rl_close)
            public void deleteHeader(){
                System.out.println("rl_close");
                remove=true;
                notifyDataSetChanged();
            }
        }
    }
}
