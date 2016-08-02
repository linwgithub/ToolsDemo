package com.linw.tudoulin.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.linw.tudoulin.R;


/**
 * 作者: linw
 * 时间: 16/7/15
 * 内容:
 */
public class MonthlyViewFragment extends Fragment {

    public static final String ARG_PAGE = "arg_page";
    private int mPage;
    public static MonthlyViewFragment getInstance(int page) {
        Bundle arg = new Bundle();
        arg.putInt(ARG_PAGE, page);
        MonthlyViewFragment mFragment = new MonthlyViewFragment();
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
        View view = inflater.inflate(R.layout.fragment_monthly_view, container, false);
        return view;
    }
}
