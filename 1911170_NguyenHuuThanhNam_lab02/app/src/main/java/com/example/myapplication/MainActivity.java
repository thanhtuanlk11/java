package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView phone;
    ImageView image;
    Button btnStart;
    LinearLayout LinearLayout1;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m001_act_profile);
//        btnStart =findViewById(R.id.btnstart);
//        btnStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                setContentView(R.layout.m001_act_profile);
//            }
//        });
//
//        bai1();
        bai2();

    }


    private void bai2(){
        phone= findViewById(R.id.phone);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_DIAL));
            }
        });
        btnBack=findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.m001_act_splash);
            }
        });
    }
    private void bai1(){
        Random r = new Random();
        int color=Color.argb(255,r.nextInt(256),r.nextInt(256),r.nextInt(256));
        LinearLayout1 = findViewById(R.id.LinearLayout1);
        LinearLayout1.setBackgroundColor(color);
        ramdomImg();
    }
    private  void ramdomImg(){
        Random r = new Random();
        image  = findViewById(R.id.image);
        int[] imgaes={R.drawable.ic_cat,R.drawable.ic_dog,R.drawable.ic_elephant,R.drawable.ic_penguin,R.drawable.ic_fish};
        image.setImageResource(imgaes[r.nextInt(imgaes.length)]);
    }


}