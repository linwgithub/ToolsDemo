package com.linw.tudoulin.ui.widget;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.linw.tudoulin.R;

/**
 * 作者: linw
 * 时间: 16/8/11
 * 内容:抽离的toolbar
 */
public class CustomToolbar {

    private Toolbar toolbar;
    private TextView toolbar_title;
    private OnBackBtnClickListener onBackBtnClickListener;

    public void setOnBackBtnClickListener(OnBackBtnClickListener onBackBtnClickListener) {
        this.onBackBtnClickListener = onBackBtnClickListener;
    }

    public interface OnBackBtnClickListener {
        void onBack();
    }

    public boolean initActionbar(AppCompatActivity activity) {
        toolbar = (Toolbar) activity.findViewById(R.id.custom_toolbar);
        if (toolbar == null) {
            return false;
        }
        toolbar_title = (TextView) toolbar.findViewById(R.id.custom_toolbar_title);
        if (activity.getTitle() != null) {
            toolbar_title.setText(activity.getTitle());
        }

        if (activity.getSupportActionBar() != null) {
            activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        toolbar.setNavigationIcon(R.drawable.left_sharp_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onBackBtnClickListener != null) {
                    onBackBtnClickListener.onBack();
                } else {
                    activity.finish();
                }
            }
        });
        return true;
    }

    public void setTitle(String title) {
        if (toolbar_title != null) {
            toolbar_title.setText(title);
        }
    }

    public String getMyTitle() {
        if (toolbar_title != null) {
            return toolbar_title.getText().toString();
        }
        return "";
    }
}
