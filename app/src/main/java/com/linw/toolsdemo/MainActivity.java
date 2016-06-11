package com.linw.toolsdemo;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    View viewMain;
    FloatingActionButton fabAdd;
    NavigationView navigation_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewMain = findViewById(R.id.main_drawer_view);
        fabAdd = (FloatingActionButton) findViewById(R.id.fab_main_add);
        if (fabAdd != null) {
            fabAdd.setOnClickListener(view -> {
                Snackbar.make(viewMain, "添加", Snackbar.LENGTH_SHORT)
                        .setAction("详情", view1 -> {

                        })
                        .show();
            });
        }
        navigation_view = (NavigationView) findViewById(R.id.navigation_view);
        if (navigation_view != null) {
            navigation_view.setNavigationItemSelectedListener(item -> {
                switch (item.getItemId()) {
                    case R.id.item_home:

                        break;
                    case R.id.item_setting:
                        Intent intent = new Intent(this, SettingActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.item_about:

                        break;
                    default:
                        break;
                }
                return false;
            });
        }
    }
}
