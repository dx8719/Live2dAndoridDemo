package com.live2d.demo;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        //XCrash.init(this);
    }
}