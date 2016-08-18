package com.linw.tudoulin.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.linw.tudoulin.R;

import java.util.HashMap;


/**
 * 作者: linw
 * 时间: 16/7/15
 * 内容:
 */
public class DailyViewFragment extends Fragment {

    public static final String ARG_PAGE = "arg_page";
    private int mPage;
    private ViewPager viewPager;
    private HashMap<Integer, View> viewMap = new HashMap<>();

    public static DailyViewFragment getInstance(int page) {
        Bundle arg = new Bundle();
        arg.putInt(ARG_PAGE, page);
        DailyViewFragment mFragment = new DailyViewFragment();
        mFragment.setArguments(arg);
        return mFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daily_view, null, false);

//        viewPager = (ViewPager) view.findViewById(R.id.viewpager_time_axis);
//        viewPager.setAdapter(weekPageAdapter);
        return view;
    }

//    PagerAdapter weekPageAdapter = new PagerAdapter() {
//        @Override
//        public int getCount() {
//            return 7;
//        }
//
//        @Override
//        public boolean isViewFromObject(View view, Object object) {
//            return view == object;
//        }
//
//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            return super.instantiateItem(container, position);
//        }
//    };
}
