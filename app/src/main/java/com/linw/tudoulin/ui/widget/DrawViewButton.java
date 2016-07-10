package com.linw.tudoulin.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者: linw
 * 时间: 16/7/9
 * 内容:
 */
public class DrawViewButton extends View {

    public DrawViewButton(Context context) {
        super(context);
    }

    public DrawViewButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawViewButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint mPaint = new Paint();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //set canvas`s color
        canvas.drawColor(Color.BLACK);

        //set paint
        mPaint.setAntiAlias(true);

        //draw
        mPaint.setColor(Color.YELLOW);
        //draw circle
        canvas.drawCircle(160, 160, 120, mPaint);
        //draw rect
        mPaint.setColor(Color.RED);
        canvas.drawRect(80, 80, 240, 240, mPaint);
        //draw oval
        mPaint.setColor(Color.GREEN);
        RectF rectF = new RectF();
        //四条边的位置
        rectF.left = 90;
        rectF.top = 100;
        rectF.right = 230;
        rectF.bottom = 220;
        canvas.drawOval(rectF, mPaint);
        //draw polygon
        Path path = new Path();
        path.moveTo(160, 100);
        path.lineTo(120, 190);
        path.lineTo(200, 190);
        path.close();
        mPaint.setColor(Color.BLACK);
        canvas.drawPath(path, mPaint);

    }
}
