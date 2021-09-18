package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnRadom;
    ImageView imgRadom;
    Integer[] image = {
            R.drawable.ic_angry,
            R.drawable.ic_beauty,
            R.drawable.ic_tire,
            R.drawable.ic_angry,
            R.drawable.ic_dribble,
            R.drawable.ic_baffle,
            R.drawable.ic_choler,
            R.drawable.ic_sure,
    };

    int pickedImage = 0, lastPicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //bài 3
       setContentView(R.layout.activity_main2);
        init();
    }
    private void init(){
        btnRadom = findViewById(R.id.btnRadom);
        imgRadom =findViewById(R.id.imgRadom);
        Random r = new Random();
        btnRadom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do {
                    pickedImage = r.nextInt(image.length);
                }while (pickedImage == lastPicked);

                lastPicked = pickedImage;
                imgRadom.setImageResource(image[pickedImage]);
            }
        });
    }

}

