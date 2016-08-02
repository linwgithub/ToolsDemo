package com.linw.tudoulin.ui.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import com.linw.tudoulin.R;
import com.linw.tudoulin.ui.fragment.Tab1Activity;
import com.linw.tudoulin.ui.fragment.Tab2Activity;

public class HomeActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        Log.e(LOG_TAG, "oncreate");
//        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        TabHost tabHost = getTabHost();
        TabHost.TabSpec tabSpec;
        Intent intent;

        //设置第1个tab
        intent = new Intent().setClass(this, Tab1Activity.class);
        tabSpec = tabHost.newTabSpec("tab1")
                .setIndicator("tab1", getResources().getDrawable(R.mipmap.ic_launcher))
                .setContent(intent);
        tabHost.addTab(tabSpec);
        //设置第2个tab
        intent = new Intent().setClass(this, Tab2Activity.class);
        tabSpec = tabHost.newTabSpec("tab2")
                .setIndicator("tab2", getResources().getDrawable(R.mipmap.ic_launcher))
                .setContent(intent);
        tabHost.addTab(tabSpec);
        tabHost.setCurrentTab(0);
    }
}
