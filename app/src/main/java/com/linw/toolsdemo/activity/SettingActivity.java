package com.linw.toolsdemo.activity;

import android.os.Bundle;
import android.view.View;

import com.linw.toolsdemo.R;
import com.linw.toolsdemo.util.BusProvider;
import com.linw.toolsdemo.util.MessageEvent;

public class SettingActivity extends MyBaseAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    public void postEventNo(View view) {
        BusProvider.getInstance().post(new MessageEvent("no", "not ok"));

    }

    public void postEventYes(View view) {
        BusProvider.getInstance().post(new MessageEvent("yes", "look it is ok"));

    }
}
