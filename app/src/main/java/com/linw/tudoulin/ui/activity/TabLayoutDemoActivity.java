package com.linw.tudoulin.ui.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import com.linw.tudoulin.R;
import com.linw.tudoulin.ui.fragment.DailyViewFragment;
import com.linw.tudoulin.ui.fragment.MonthlyViewFragment;

import java.util.ArrayList;

public class TabLayoutDemoActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TabLayout mTabLayout;
    private ViewPager mPager;
    private ArrayList<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tab_layout_demo);

//        log.e(TAG, "onCreate");
        Log.e(TAG, "oncreate");
        InitViewPager();
    }

    public void InitViewPager() {
        mTabLayout = (TabLayout) findViewById(R.id.main_tablayout);
        mPager = (ViewPager) findViewById(R.id.viewpager);

        mPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mPager);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
//        mPager.setCurrentItem(0);
    }

    public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        String[] fragmentTitle = {"Monthly View", "Daily View"};

        Fragment fragments[] = {DailyViewFragment.getInstance(0), MonthlyViewFragment.getInstance(1)};

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        @Override
        public Fragment getItem(int arg0) {
            return fragments[arg0];
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle[position];
        }
    }
}
