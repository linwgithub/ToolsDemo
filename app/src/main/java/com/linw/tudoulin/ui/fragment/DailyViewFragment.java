package com.linw.tudoulin.ui.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.linw.tudoulin.R;

import java.util.HashMap;


/**
 * 作者: linw
 * 时间: 16/7/15
 * 内容:
 */
public class DailyViewFragment extends Fragment {

    public static final String ARG_PAGE = "arg_page";
    public static final String TAG = "DailyViewFragment";
    public static final int INENT_REQUEST_CODE = 0x11;

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
        Button btnApplyPermission = (Button) view.findViewById(R.id.btn_applaypermission);
        btnApplyPermission.setOnClickListener(view1 -> {
            fragmentApplyPermission();
        });
//        viewPager = (ViewPager) view.findViewById(R.id.viewpager_time_axis);
//        viewPager.setAdapter(weekPageAdapter);
        return view;
    }

    private void fragmentApplyPermission() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //申请权限
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    INENT_REQUEST_CODE);
        } else {
            Log.e(TAG, "permission granted");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //请求权限回调
        if (requestCode == INENT_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //
                Log.e(TAG, "permission granted");
            } else {
                Log.e(TAG, "permission denind");
            }
        }
        for (String permission : permissions) {
            Log.e(TAG, "granted permission:" + permission);
        }
        Log.e(TAG, "onRequestPermissionsResult:permission:" + permissions[0] + "\ngrantResults" + grantResults[0]);

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
