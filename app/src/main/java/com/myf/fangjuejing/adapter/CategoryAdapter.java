package com.myf.fangjuejing.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.myf.fangjuejing.MainActivity;
import com.myf.fangjuejing.R;
import com.myf.fangjuejing.bean.Category;
import com.myf.fangjuejing.helper.SharePrefHelper;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by MaoYouFeng on 2016/5/29.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    List<Category> categories;
    private HashMap<String, String> homeCategorys = new HashMap();
    private Context mContext;

    public CategoryAdapter(Context mContext, List<Category> categories) {
        this.categories = categories;
        this.mContext = mContext;
        if(!SharePrefHelper.getFirstCatagoryKey().equals("")){
            homeCategorys.put(SharePrefHelper.getFirstCatagoryKey(),SharePrefHelper.getFirstCatagoryValue());
        }
        if(!SharePrefHelper.getSecondCatagoryKey().equals("")){
            homeCategorys.put(SharePrefHelper.getSecondCatagoryKey(),SharePrefHelper.getSecondCatagoryValue());
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category_subscribe_main_page, parent, false);
        return new ViewHolder(v, parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Category category = categories.get(position);
        holder.icon.setImageResource(category.imgId);
        holder.title.setText(category.title);
        holder.iv_menu.setColorFilter(R.color.icon_disabled);
        if(homeCategorys.size()!=0){
            if (homeCategorys.containsKey(category.name))
                holder.status.setText("已在首页显示");
        }
        else
            holder.status.setText("");
        holder.category = category;
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_category_icon)
        ImageView icon;
        @Bind(R.id.tv_card_title)
        TextView title;
        @Bind(R.id.tv_status)
        TextView status;
        @Bind(R.id.iv_menu)
        ImageView iv_menu;

        Category category;

        public ViewHolder(View itemView, ViewGroup parent) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.iv_menu)
        public void onClickMenu(View view) {
            PopupMenu popupMenu = new PopupMenu(mContext, view);
            MenuInflater inflater = popupMenu.getMenuInflater();
            if (!homeCategorys.containsKey(category.name))
                inflater.inflate(R.menu.menu_pop_show_in_home, popupMenu.getMenu());
            else
                inflater.inflate(R.menu.menu_pop_hide_in_home, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new MenuClickListener(category));
            popupMenu.show();
        }
    }

    class MenuClickListener implements PopupMenu.OnMenuItemClickListener {
        Category category;

        public MenuClickListener(Category category) {
            this.category = category;
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_show_in_main:
                    if (homeCategorys.size() < 2 && !homeCategorys.containsKey(category.name)) {
                        category.isSetHome = true;
                        homeCategorys.put(category.name, category.title);
                    } else
                        showMax(category);
                    break;
                case R.id.action_hide_in_main:
                    category.isSetHome = false;
                    homeCategorys.remove(category.name);
                    break;
            }
            notifyDataSetChanged();
            int len =homeCategorys.size();
            if(len==0) {
                SharePrefHelper.delCatagory(0);
                SharePrefHelper.delCatagory(1);
            }else if (len == 1){
                String key  = (String)homeCategorys.keySet().toArray()[0];
                String value=homeCategorys.get(key);
                SharePrefHelper.setFirstCatagory(key,value);
                SharePrefHelper.delCatagory(1);
            }else{
                String key  = (String)homeCategorys.keySet().toArray()[1];
                String value=homeCategorys.get(key);
                SharePrefHelper.setSecondCatagory(key,value);
            }
            EventBus.getDefault().post(homeCategorys);
            return true;
        }
    }

    private void showMax(final Category category) {
        new MaterialDialog.Builder(mContext)
                .content(R.string.dialog_content_special_show)
                .neutralText(R.string.cancel)
                .positiveText(mContext.getString(R.string.dialog_button_replace_category_name
                        , new Object[]{homeCategorys.values().toArray()[0]}))
                .negativeText(mContext.getString(R.string.dialog_button_replace_category_name
                        , new Object[]{homeCategorys.values().toArray()[1]}))
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        replaceCategory(1, category);
                    }
                })
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        replaceCategory(0, category);
                    }
                })
                .show();
    }

    private void replaceCategory(int index, Category category) {
        homeCategorys.remove(homeCategorys.keySet().toArray()[index]);
        homeCategorys.put(category.name, category.title);
        if (index == 0)
            SharePrefHelper.setFirstCatagory(category.name, category.title);
        else
            SharePrefHelper.setSecondCatagory(category.name, category.title);
        notifyDataSetChanged();
    }

}
