package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    String[] arr = new String[]{"Android","IOS","Windows Phone"};
    ListView lvMain;
    TextView txtDisplay;
    String[] titles = new String[]{"Android","IOS","Windows Phone"};
    String [] contents = new String[]{"Đây là hệ điều hành android",
                                        "Đây là hệ điều hành IOS",
                                        "Đây là hệ điều hành Windows Phone"};
    int[]imgs= new int[]{R.drawable.android,
    R.drawable.ios,
    R.drawable.windows_mobie};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMain = findViewById(R.id.lvMain);
        txtDisplay = findViewById(R.id.txtDisplay);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1,arr);
//        lvMain.setAdapter(adapter);
//        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                txtDisplay.setText(arr[position]);
//            }
//        });
        ArrayList<Product> list = new ArrayList<>();
        for (int i = 0;i<titles.length;i++){
            list.add(new Product(imgs[i],titles[i],contents[i]));
        }
        MyListViewAdapter adapter = new MyListViewAdapter(list);
        lvMain.setAdapter(adapter);
        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              txtDisplay.setText("Bạn chọn `"+titles[position]);
            }
        });

    }

}