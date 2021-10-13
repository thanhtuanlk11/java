package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    TextView txtDiem;
    CheckBox cbOne,cbTwo,cbThree;
    SeekBar skOne,skTwo,skThree;
    ImageButton ibtnPlay;
    int SoDiem =100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        AnhXa();

        skOne.setEnabled(false);
        skTwo.setEnabled(false);
        skThree.setEnabled(false);
        txtDiem.setText(SoDiem+"");
        CountDownTimer countDownTimer = new CountDownTimer(60000,300) {

            @Override
            public void onTick(long l) {
                int number = 5;
                Random radoom = new Random();
                int one = radoom.nextInt(number);
                int two = radoom.nextInt(number);
                int three = radoom.nextInt(number);

                //Kiểm tra ai thắng
                if(skOne.getProgress() >=skOne.getMax()){
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity2.this, "One win", Toast.LENGTH_SHORT).show();
                    //Kiểm tra đặt cược
                    if(cbOne.isChecked()){
                        SoDiem +=10;
                        Toast.makeText(MainActivity2.this, "Bạn đoán chính xác", Toast.LENGTH_SHORT).show();
                    }else{
                        SoDiem -=5;
                        Toast.makeText(MainActivity2.this, "Bạn đoán sai", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(SoDiem +"");
                    EnableCheckBox();
                }
                if(skTwo.getProgress() >=skTwo.getMax()){
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity2.this, "Two win", Toast.LENGTH_SHORT).show();
                    if(cbTwo.isChecked()){
                        SoDiem +=10;
                        Toast.makeText(MainActivity2.this, "Bạn đoán chính xác", Toast.LENGTH_SHORT).show();
                    }else{
                        SoDiem -=5;
                        Toast.makeText(MainActivity2.this, "Bạn đoán sai", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(SoDiem +"");
                    EnableCheckBox();
                }
                if(skThree.getProgress() >=skThree.getMax()){
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity2.this, "Three win", Toast.LENGTH_SHORT).show();
                    if(cbThree.isChecked()){
                        SoDiem +=10;
                        Toast.makeText(MainActivity2.this, "Bạn đoán chính xác", Toast.LENGTH_SHORT).show();
                    }else{
                        SoDiem -=5;
                        Toast.makeText(MainActivity2.this, "Bạn đoán sai", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(SoDiem +"");
                    EnableCheckBox();
                }

                skOne.setProgress(skOne.getProgress() +one);
                skTwo.setProgress(skTwo.getProgress()+two);
                skThree.setProgress(skThree.getProgress() +three);
            }

            @Override
            public void onFinish() {

            }
        };
        ibtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbOne.isChecked()||cbTwo.isChecked()||cbThree.isChecked()){
                    skOne.setProgress(0);
                    skTwo.setProgress(0);
                    skThree.setProgress(0);
                    ibtnPlay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                    DisableCheckBox();
                }
                else {
                    Toast.makeText(MainActivity2.this, "Vui lòng đặt cược trước khi chơi", Toast.LENGTH_SHORT).show();
                }

            }
        });
        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbTwo.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                cbOne.setChecked(false);
                cbThree.setChecked(false);
            }
        });
        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                cbOne.setChecked(false);
                cbTwo.setChecked(false);
            }
        });
    }
    private void EnableCheckBox(){
        cbOne.setEnabled(true);
        cbTwo.setEnabled(true);
        cbThree.setEnabled(true);

    }
    private void DisableCheckBox(){
        cbOne.setEnabled(false);
        cbTwo.setEnabled(false);
        cbThree.setEnabled(false);
    }
    private void AnhXa(){
        txtDiem =(TextView) findViewById(R.id.txtDiemSo);
        ibtnPlay =(ImageButton) findViewById(R.id.btnPlay);
        cbOne = (CheckBox) findViewById(R.id.checkboxOne);
        cbTwo =(CheckBox)  findViewById(R.id.checkboxTwo);
        cbThree =(CheckBox) findViewById(R.id.checkboxThree);
        skOne =(SeekBar) findViewById(R.id.seeBarOne);
        skTwo = (SeekBar)  findViewById(R.id.seebarTwo);
        skThree = (SeekBar) findViewById(R.id.seebarThree);
    }
}