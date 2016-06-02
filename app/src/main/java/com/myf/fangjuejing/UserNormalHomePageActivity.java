package com.myf.fangjuejing;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.myf.fangjuejing.adapter.UserAdapter;
import com.myf.fangjuejing.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


public class UserNormalHomePageActivity extends BaseActivity {

    public static void startActivity(Context context){
        context.startActivity(new Intent(context,UserNormalHomePageActivity.class));
    }

    @Bind(R.id.main_appbar)
    AppBarLayout app_bar_layout;
    @Bind(R.id.main_collapsing)
    CollapsingToolbarLayout main_collapsing;
    @Bind(R.id.main_toolbar)
    Toolbar main_toolbar;
    @Bind(R.id.main_imageview_background)
    ImageView main_imageview_background;
    @Bind(R.id.layout_user_info)
    LinearLayout layout_user_info;
    @Bind(R.id.tv_nickname)
    TextView tv_nickname;
    @Bind(R.id.tv_pos_com)
    TextView tv_pos_com;
    @Bind(R.id.iv_avatar)
    CircleImageView iv_avatar;

    @Bind(R.id.toolbar_tab)
    TabLayout toolbar_tab;
    @Bind(R.id.main_vp_container)
    ViewPager main_vp_container;

    @Override
    protected int initContentView() {
        return R.layout.activity_persional_user_home_page;
    }
    @Override
    protected void initUiAndListener() {
        ButterKnife.bind(this);
        initToolBar(main_toolbar);
        UserAdapter vpAdapter = new UserAdapter(getSupportFragmentManager());

        main_vp_container.setAdapter(vpAdapter);
        main_vp_container.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(toolbar_tab));
        toolbar_tab.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(main_vp_container));

    }

    Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            String msg = "";
            switch (menuItem.getItemId()) {
                case R.id.action_blog:
                    msg += "博客跳转";
                    break;
                case R.id.action_weibo:
                    msg += "微博跳转";
                    break;
                case R.id.action_settings:
                    msg += "设置";
                    break;
            }

            if (!msg.equals("")) {
                Toast.makeText(UserNormalHomePageActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };

    private void initToolBar(Toolbar mToolBar) {
        if (null != mToolBar) {
            setSupportActionBar(mToolBar);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            mToolBar.setOnMenuItemClickListener(onMenuItemClick);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_persional_home_page, menu);
        return true;
    }



}
