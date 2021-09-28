package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class MainActivity4 extends AppCompatActivity {
    GridView gridView;
    String[] ten = {
            "Maboo", "SameOldShawn" , "Magnitude901","Brandon","Clement_RGF","Nebja","BBDS","PleseDe-ModeMe","DLizzle","palacelight","TheDarkNight","hellrel",

    };
    String[] mota = {"283,297","252,433","164,935","100,466","93,932","84,187","81,762","79,243","76,331","75,497","69,138","69,903",


    };
    int[] hinh = {

            R.drawable.grid1 ,R.drawable.grid2, R.drawable.grid3 ,R.drawable.grid4 , R.drawable.grid5 ,R.drawable.grid6 , R.drawable.grid7 ,R.drawable.grid8 , R.drawable.grid9 ,R.drawable.grid10 , R.drawable.grid11 , R.drawable.grid12 ,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        gridView =(GridView) findViewById(R.id.gridView4);
        GridViewAdapter gridViewAdapter = new GridViewAdapter(this,ten, mota, hinh);
        gridView.setAdapter(gridViewAdapter);
    }
}