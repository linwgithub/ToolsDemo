package com.linw.tudoulin;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * 作者: linw
 * 时间: 16/6/12
 * 内容:
 */
public class MainApplication extends Application {

//    获取MainApplication的单例
//    private static MainApplication app;

//    public static MainApplication getInstance() {
//        return app;
//    }

//    @Override
//    public void onCreate() {
//        super.onCreate();
//        app = this;
//    }

    private RefWatcher refWatcher;

    public static RefWatcher getRefWatcher(Context context) {
        MainApplication application = (MainApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher = LeakCanary.install(this);
    }
}
