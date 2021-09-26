package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity2 extends AppCompatActivity {
    private int SeeBarR,SeeBarG,SeeBarB;
    private int SeeBarC,SeeBarM,SeeBarY;
    SeekBar red,green,blue;
    EditText myScreen1,myScreen2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myScreen1 =findViewById(R.id.myScreen1);
        myScreen2 = findViewById(R.id.myScreen2);
        red = findViewById(R.id.red);
        green = findViewById(R.id.green);
        blue = findViewById(R.id.blue);
        BackgroundColorUpdate();

        red.setOnSeekBarChangeListener(seekBarChangeListener);
        green.setOnSeekBarChangeListener(seekBarChangeListener);
        blue.setOnSeekBarChangeListener(seekBarChangeListener);
    }
    private SeekBar.OnSeekBarChangeListener seekBarChangeListener =new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            BackgroundColorUpdate();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
    private void BackgroundColorUpdate(){
        SeeBarR= red.getProgress();
        SeeBarG =green.getProgress();
        SeeBarB = blue.getProgress();

        myScreen1.setBackgroundColor(
                0xff000000
                        +SeeBarR*0x10000
                        +SeeBarG*0*100
                        +SeeBarB);
        myScreen2.setBackgroundColor(
                0xff000000
                        +255 - SeeBarR
                        +255 - SeeBarG
                        +255 - SeeBarY);
    }
}