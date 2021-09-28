package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ListView listView;
        ArrayList<MonAn> arrayList;

        listView = findViewById(R.id.listviewmonan);
        AdapterMonAn adapter;
        arrayList = new ArrayList<>();
        arrayList.add(new MonAn("Hamberger","Bánh mì kẹp thịt tròn","Giá:12.000đ",R.drawable.food1));
        arrayList.add(new MonAn("Bánh mì","Bánh mì kẹp thịt","Giá:10.000đ",R.drawable.food2));
        arrayList.add(new MonAn("Bánh bao","Bánh bao nhân thịt, trứng","Giá:20.000đ",R.drawable.food_banhbao));
        arrayList.add(new MonAn("Cơm thịt nướng","Cơm thịt nướng, trứng ốp la","Giá:30.000đ",R.drawable.food_comthitnuong));
        arrayList.add(new MonAn("Cơm gà xối mỡ","Cơm một đùi một cánh","Giá:50.000đ",R.drawable.food_comga));



        adapter =new AdapterMonAn(MainActivity3.this,R.layout.layout_monan,arrayList);
        listView.setAdapter(adapter);
    }
}