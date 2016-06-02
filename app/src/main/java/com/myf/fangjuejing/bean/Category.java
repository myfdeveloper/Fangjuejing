package com.myf.fangjuejing.bean;

/**
 * Created by MaoYouFeng on 2016/5/29.
 */
public class Category {

    public Category(int imgId,String title){
        this.name="c"+imgId;
        this.imgId=imgId;
        this.title=title;
    }
    public String name;
    public int imgId;
    public String title;
    public boolean isSetHome;
}
