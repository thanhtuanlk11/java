package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.jar.Attributes;

public class MyCanvas extends View {
    public static int color = Color.YELLOW;
    public MyCanvas(Context context){
        super(context,null);
    }
    public MyCanvas(Context context, AttributeSet attrs){
        super(context,attrs,0);
    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        //Vẽ nền vàng
        canvas.drawColor(color);
//        drawText(canvas,"Thành Nam");
        drawRect(canvas);
    }
    private void drawText(Canvas canvas,String mMessage){
        int viewWidth = getWidth();
        int viewHeight = getHeight();
        canvas.translate(viewWidth/2,viewHeight/2);
        Paint mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(60f);

        for(int i=0;i<10;i++){
            canvas.drawText(mMessage,0,0,mPaint);
            canvas.rotate(36);
        }
    }
    private void drawRect(Canvas canvas){
        int pos=10;
        int viewWidth=getWidth();
        int viewHeight = getHeight();
        Paint mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(pos,viewHeight/2,pos +viewWidth/5,viewHeight,mPaint);
        mPaint.setColor(Color.RED);
        canvas.drawRect(pos*2 +viewWidth/5,viewHeight/2-100,
                (pos+viewWidth/5)*2,viewHeight,mPaint);
    }
}
