package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyCanvas1 extends View {
    public static int color = Color.WHITE;
    public static int color2 = Color.BLACK;
    public MyCanvas1(Context context){super(context,null);}
    public MyCanvas1(Context context, AttributeSet attrs){super(context,attrs,0);}
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawColor(color2);
//        drawRect(canvas);
        drawRect2(canvas);
        drawText(canvas,"kWh");
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
    private void drawRect2(Canvas canvas){
        int viewWith = getWidth();
        int viewHeight = getHeight();
        Paint mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(10,viewHeight/2-500, viewWith/75,viewHeight-5,mPaint);
        canvas.drawRect(10+10,viewHeight/2+300,viewWith/10+10,viewHeight-10,mPaint);
        canvas.drawRect(128,viewHeight/2-100,viewHeight/10+98,viewHeight-10,mPaint);
        canvas.drawRect(236,viewHeight/2-300,viewHeight/10+206,viewHeight-10,mPaint);
        canvas.drawRect(344,viewHeight/2+350,viewHeight/10+314,viewHeight-10,mPaint);
        canvas.drawRect(452,viewHeight/2-270,viewHeight/10+422,viewHeight-10,mPaint);
        canvas.drawRect(560,viewHeight/2+300,viewHeight/10+530,viewHeight-10,mPaint);
        canvas.drawRect(668,viewHeight/2+500,viewHeight/10+638,viewHeight-10,mPaint);
        canvas.drawRect(776,viewHeight/2+550,viewHeight/10+746,viewHeight-10,mPaint);
        canvas.drawRect(884,viewHeight/2+600,viewHeight/10+854,viewHeight-10,mPaint);
        canvas.drawRect(10,viewHeight, viewWith/2+450,viewHeight-5,mPaint);
    }
    private void drawText(Canvas canvas,String mMessage){
        int viewWith = getWidth();
        int viewHeight = getHeight();
        Paint mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setTextSize(80f);
        canvas.drawText("kWh",40,220,mPaint);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(80f);
        canvas.drawText("3",40,1020,mPaint);
        canvas.drawText("6",155,620,mPaint);
        canvas.drawText("8",260,410,mPaint);
        canvas.drawText("2",370,1070,mPaint);
        canvas.drawText("7",470,450,mPaint);
        canvas.drawText("3",580,1020,mPaint);
        canvas.drawText("1",690,1216,mPaint);

    }

}
