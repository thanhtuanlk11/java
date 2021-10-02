package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyCanvas1 extends View {
    public static int color = Color.WHITE;
    public MyCanvas1(Context context){super(context,null);}
    public MyCanvas1(Context context, AttributeSet attrs){super(context,attrs,0);}
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawColor(color);
        drawRect(canvas);
    }
    private void drawRect(Canvas canvas){

        int viewWidth=getWidth();
        int viewHeight = getHeight();
        Paint mPaint = new Paint();
        mPaint.setColor(Color.BLUE);

        canvas.drawRect(0,viewHeight /2,viewWidth/6,viewHeight,mPaint);
        mPaint.setColor(Color.RED);
        canvas.drawRect(180,viewHeight/2-500,viewWidth/6+ 180,viewHeight,mPaint);
        mPaint.setColor(Color.CYAN);
        canvas.drawRect(360,viewHeight/2+500,viewWidth/6 +360,viewHeight,mPaint);
        mPaint.setColor(Color.GREEN);
        canvas.drawRect(540,viewHeight/2+100,viewWidth/6 +540,viewHeight,mPaint);
        mPaint.setColor(Color.MAGENTA);
        canvas.drawRect(720,viewHeight/2-300,viewWidth/6+720,viewHeight,mPaint);
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(900,viewHeight/2-400,viewWidth/6+900,viewHeight,mPaint);

    }
}
