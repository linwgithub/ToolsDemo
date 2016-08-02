package com.linw.tudoulin.ui.activity;

import android.content.Intent;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.linw.tudoulin.R;
import com.linw.tudoulin.util.BusProvider;
import com.linw.tudoulin.util.MessageEvent;
import com.squareup.otto.Subscribe;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    View viewMain;
    FloatingActionButton fabAdd;
    NavigationView navigation_view;
    TextView tvMainContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注册订阅
        BusProvider.getInstance().register(this);

        long time = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        Log.e("weekis", "week:" + weekDay);


        viewMain = findViewById(R.id.main_drawer_view);
        tvMainContent = (TextView) findViewById(R.id.tv_main_content);
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
                        Intent homeintent = new Intent(this, HomeActivity.class);
                        startActivity(homeintent);
                        break;
                    case R.id.item_setting:
                        Intent intent = new Intent(this, SettingActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.item_about:
                        startActivity(new Intent(this, TabLayoutDemoActivity.class));
                        break;
                   case R.id.item_list:
                        startActivity(new Intent(this, ShowHorizontalListView.class));
                        break;
                    default:
                        break;
                }
                return false;
            });
        }
    }

    //添加注释表示该方法订阅了MessageEvent，PS：该方法必须用public修饰
    @Subscribe
    public void showEvent(MessageEvent event) {
        if (event.msg.equals("yes")) {
            tvMainContent.setText(event.obj.toString());
        } else if (event.msg.equals("no")) {
            tvMainContent.setText(event.obj.toString());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BusProvider.getInstance().unregister(this);
    }
}
