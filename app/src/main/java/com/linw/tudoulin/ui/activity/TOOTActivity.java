package com.linw.tudoulin.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.linw.tudoulin.R;
import com.linw.tudoulin.base.MyBaseAppCompatActivity;
import com.linw.tudoulin.util.BusProvider;
import com.linw.tudoulin.util.MessageEvent;

public class TOOTActivity extends MyBaseAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toot);
        initActionBar();
        setTitle("util test");
    }

    public void postEventNo(View view) {
        BusProvider.getInstance().post(new MessageEvent("no", "not ok"));

    }

    public void postEventYes(View view) {
        BusProvider.getInstance().post(new MessageEvent("yes", "look it is ok"));

    }
}
