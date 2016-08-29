package com.linw.tudoulin.ui.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.linw.tudoulin.R;
import com.linw.tudoulin.databinding.ActivityAdjustAndoridNBinding;

public class AdjustAndoridNActivity extends AppCompatActivity {

    private static final String TAG = "AdjustAndoridNActivity";
    ActivityAdjustAndoridNBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_adjust_andorid_n);

    }

    public void onBtnClickEvent(View view) {
        switch (view.getId()) {
            case R.id.btn_is_in_mul_win:
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    boolean isInMulWin = isInMultiWindowMode();
                    Log.e(TAG, "isInMulWin:" + isInMulWin);
                } else {
                    Log.e(TAG, "sbk less then Android N");
                }

                break;
            case R.id.btn_is_p_in_p:
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    boolean isInPInP= isInPictureInPictureMode();
                    Log.e(TAG, "isInPInP:" + isInPInP);
                } else {
                    Log.e(TAG, "sbk less then Android N");
                }
                break;
        }
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        super.onMultiWindowModeChanged(isInMultiWindowMode);
        Log.e(TAG, "onMultiWindowModeChanged:" + isInMultiWindowMode);
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
        Log.e(TAG, "onPictureInPictureModeChanged:" + isInPictureInPictureMode);
    }
}
