package myapplication.nguyenhuuthanhnam.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class OVuong extends androidx.appcompat.widget.AppCompatTextView {
    public OVuong(Context context) {
        super(context);
    }

    public OVuong(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public OVuong(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int dai = getMeasuredWidth();
        setMeasuredDimension(dai,dai);
    }
    public void setTextt(int so){
        if(so < 100) {
            setTextSize(40);
        }else if(so<1000){
            setTextSize(35);
        }else{
            setTextSize(30);
        }


        if(so>=8){
            setTextColor(Color.WHITE);
        }else{
            setTextColor(Color.BLACK);
        }


        GradientDrawable drawable =(GradientDrawable)this.getBackground();
        drawable.setColor(Datagame.getDatagame().colorr(so));
        setBackground(drawable);

        if(so == 0){
            setText("");
        }else  {
            setText(""+so);
        }
    }
}
