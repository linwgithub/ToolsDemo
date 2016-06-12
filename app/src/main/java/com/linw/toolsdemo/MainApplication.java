package com.linw.toolsdemo;

import android.app.Application;

/**
 * 作者: linw
 * 时间: 16/6/12
 * 内容:
 */
public class MainApplication extends Application {

    private static MainApplication app;

    public static MainApplication getInstance() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
