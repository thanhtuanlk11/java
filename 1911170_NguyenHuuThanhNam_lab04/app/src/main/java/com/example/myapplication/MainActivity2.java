package com.example.myapplication;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

// bài 2
public class MainActivity2 extends AppCompatActivity{
    private static final int[] ID_DRAWABLES = {R.drawable.ic_mess, R.drawable.ic_flight,
            R.drawable.ic_hospital,
            R.drawable.ic_hotel, R.drawable.ic_restaurant, R.drawable.ic_coctail,
            R.drawable.ic_store, R.drawable.ic_at_work, R.drawable.ic_time, R.drawable.ic_education,
            R.drawable.ic_movies};
    private static final int[] ID_TEXTS = {R.string.txt_mess, R.string.txt_flight, R.string.txt_hospital,
            R.string.txt_hotel, R.string.txt_restaurant, R.string.txt_coctail,
            R.string.txt_store, R.string.txt_work, R.string.txt_time, R.string.txt_education, R.string.txt_movie};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        ImageView iv_dialer = findViewById(R.id.iv_dialer);
        iv_dialer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(MainActivity2.this);
                LayoutInflater inflater = getLayoutInflater();
                View view =inflater.inflate(R.layout.layout_custom_toast2,(ViewGroup)findViewById(R.id.layout_custom_toast2));
                TextView tv_message2 = view.findViewById(R.id.tv_message2);
                tv_message2.setText("sleep");
                toast.setView(view);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
            }
        });




    }
    private void initView() {
        LinearLayout lnMain = findViewById(R.id.ln_main);
        lnMain.removeAllViews();
//Tạo ra các Item topic động và add vào LinearLayout
        for (int i = 0; i < ID_DRAWABLES.length; i++) {
            View v = LayoutInflater.from(this).inflate(R.layout.item_topic, null);
            ImageView ivTopic = v.findViewById(R.id.iv_topic);
            TextView tvTopic = v.findViewById(R.id.tv_topic);
            ivTopic.setImageResource(ID_DRAWABLES[i]);
            tvTopic.setText(ID_TEXTS[i]);
//Quy định không gian chiếm của mỗi item view = 1
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    1.0f
            );
            v.setLayoutParams(param);
            lnMain.addView(v);
        }
    }
}
