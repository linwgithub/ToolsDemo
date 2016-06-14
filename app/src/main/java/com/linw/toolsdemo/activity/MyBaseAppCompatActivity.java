package com.linw.toolsdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.linw.toolsdemo.R;

/**
 * 作者: linw
 * 时间: 16/6/12
 * 内容:
 */
public class MyBaseAppCompatActivity extends AppCompatActivity {

    protected Toolbar toolbar;
    protected TextView toolbar_title;
    private OnBackBtnClickListener onBackBtnClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public interface OnBackBtnClickListener {
        void onBack();
    }

    public boolean initActionBar() {
        Log.e(getLocalClassName(), "initActionBar-null");
        return initActionBar(null);
    }

    public boolean initActionBar(final OnBackBtnClickListener backBtnClickListener) {
        toolbar = (Toolbar) findViewById(R.id.activity_toolbar);
        if (toolbar == null) {
            return false;
        }
        toolbar_title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        if (TextUtils.isEmpty(getTitle())) {
            toolbar_title.setText(getTitle());
        }
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        toolbar.setNavigationIcon(R.drawable.left_sharp_white);
        toolbar.setNavigationOnClickListener(view -> {
            if (backBtnClickListener != null) {
                onBackBtnClickListener.onBack();
            } else {
                finish();
            }
        });
        return true;
    }

    public void setTitle(String title) {
        if (toolbar_title != null) {
            toolbar_title.setText(title);
        }
    }
}
