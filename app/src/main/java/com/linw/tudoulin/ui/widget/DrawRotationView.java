package com.linw.tudoulin.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.linw.tudoulin.R;

/**
 * 作者: linw
 * 时间: 16/7/10
 * 内容:
 */
public class DrawRotationView extends View implements Runnable{

    private String TAG = "DrawRotationView";
    private Bitmap starBitmap = null;
    private int starWidth = 0;
    private int starHeight = 0;
    private float startAngle = 0;
    private Matrix starMatrix = new Matrix();

    public DrawRotationView(Context context) {
        super(context);
        Log.e(TAG, "DrawRotationView(Context context)");
        Resources res = this.getResources();
        starBitmap = BitmapFactory.decodeResource(res, R.drawable.icon_center);
        starWidth = starBitmap.getWidth();
        starHeight = starBitmap.getHeight();
        //开始重绘
        new Thread(this).start();
    }

    public DrawRotationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.e(TAG, "DrawRotationView(Context context, AttributeSet attrs)");

        Resources res = this.getResources();
        starBitmap = BitmapFactory.decodeResource(res, R.drawable.icon_center);
        starWidth = starBitmap.getWidth();
        starHeight = starBitmap.getHeight();
        //开始重绘
        new Thread(this).start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e(TAG, "onDraw");
        //重置旋转矩阵
        starMatrix.reset();
        //设置旋转中心
        float transX = 100;
        float transY = 100;

        starMatrix.setRotate(startAngle, starWidth / 2, starHeight / 2);
//        starMatrix.postTranslate(transX, transY);

        //重新绘制bitmap
        Bitmap newBitmap = Bitmap.createBitmap(starBitmap, 0, 0, starWidth, starHeight, starMatrix, true);
        canvas.drawBitmap(newBitmap, 0, 0, null);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(20);
                startAngle++;
                Log.e(TAG, "run:" + startAngle);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.postInvalidate();

        }
    }
}
