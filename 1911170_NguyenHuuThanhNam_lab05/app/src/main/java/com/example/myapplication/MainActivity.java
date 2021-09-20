package com.example.myapplication;

import static com.example.myapplication.R.anim.alpha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView ivAnimal;
    private Button btnRadom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    private void initViews() {
        ivAnimal = findViewById(R.id.iv_animal);
        btnRadom = findViewById(R.id.btnRadom);

        findViewById(R.id.bt_alpha).setOnClickListener(this);
        findViewById(R.id.bt_rotate).setOnClickListener(this);
        findViewById(R.id.bt_scale).setOnClickListener(this);
        findViewById(R.id.bt_trans).setOnClickListener(this);
        btnRadom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ramdom();
            }
        });

    }
    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.bt_alpha) {
            ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, alpha ));
        } else if (v.getId() == R.id.bt_rotate) {
            ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate));
        } else if (v.getId() == R.id.bt_scale) {
            ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale));
        } else if (v.getId() == R.id.bt_trans) {
            ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.translate));
        }

    }
    private void ramdom(){
        Random r = new Random();
        int number = r.nextInt(4);
        switch (number){
            case 1:
                ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, alpha ));
                break;
            case 2:
                ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate));
                break;
            case 3:
                ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale));
                break;
            case 4:
                ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.translate));
                break;
        }
    }
}