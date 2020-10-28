package com.example.cloudmusic;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //初始化utilCodex
        Utils.init(this);
    }
}
