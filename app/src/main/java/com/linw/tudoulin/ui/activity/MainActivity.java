package com.linw.tudoulin.ui.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.linw.tudoulin.R;
import com.linw.tudoulin.databinding.ActivityMainBinding;
import com.linw.tudoulin.util.BusProvider;
import com.linw.tudoulin.util.MessageEvent;
import com.squareup.otto.Subscribe;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //注册订阅
        BusProvider.getInstance().register(this);

        initView();
    }

    private void initView() {
        if (binding.fabMainAdd != null) {
            binding.fabMainAdd.setOnClickListener(view -> {
                Snackbar.make(binding.mainDrawerView, "添加", Snackbar.LENGTH_SHORT)
                        .setAction("详情", view1 -> {
                            Toast.makeText(MainActivity.this, "Toast frome Snackbar", Toast.LENGTH_SHORT).show();
                        })
                        .show();
            });
        }
        if (binding.navigationView != null) {
            binding.navigationView.setNavigationItemSelectedListener(item -> {
                String itemResult = "";
                switch (item.getItemId()) {
                    case R.id.item_home:
                        itemResult = "首页";
                        break;
                    case R.id.item_setting:
                        itemResult = "设置";
                        break;
                    case R.id.item_about:
                        itemResult = "关于";
                        break;
                    case R.id.item_list:
                        itemResult = "列表";
                        break;
                    default:
                        break;
                }
                Snackbar.make(binding.mainDrawerView, itemResult, Snackbar.LENGTH_SHORT).show();
                return false;
            });
        }
    }

    public void mainBtnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_tablayout:
                startActivity(new Intent(this, TabLayoutDemoActivity.class));
                break;
            case R.id.btn_tabactivity:
                startActivity(new Intent(this, TabActivityDemoActivity.class));
                break;
            case R.id.btn_toot_result:
                startActivity(new Intent(this, TOOTActivity.class));
                break;
            case R.id.btn_toot_horizontallist:
                startActivity(new Intent(this, ShowHorizontalListView.class));
                break;
            case R.id.btn_databinding:
                startActivity(new Intent(this, BindingTextActivity.class));
                break;
            case R.id.btn_adjust_n:
                startActivity(new Intent(this, AdjustAndoridNActivity.class));
                break;
            default:
                break;

        }
    }

    //添加注释表示该方法订阅了MessageEvent，PS：该方法必须用public修饰
    @Subscribe
    public void showEvent(MessageEvent event) {
        if (event.msg.equals("yes")) {

            binding.tvMainContent.setText(event.obj.toString());
        } else if (event.msg.equals("no")) {
            binding.tvMainContent.setText(event.obj.toString());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //及时注销订阅
        BusProvider.getInstance().unregister(this);
    }

    /**
     * 星期几
     */
    public void getToWeekDay() {
        Calendar calendar = Calendar.getInstance();
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        Log.e("weekis", "week:" + weekDay);
    }
}
