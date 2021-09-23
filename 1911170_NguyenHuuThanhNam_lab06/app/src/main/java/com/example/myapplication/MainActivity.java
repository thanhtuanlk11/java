package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private EditText txtNumber;
    private Spinner spnUnits;
    private TextView[] lblResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumber =(EditText)findViewById(R.id.txtNumber);
        spnUnits =(Spinner)findViewById(R.id.spnUnit);
        lblResults = new TextView[]{
                (TextView)findViewById(R.id.lblUsd),
                (TextView)findViewById(R.id.lblEur),
                (TextView)findViewById(R.id.lblGbp),
                (TextView)findViewById(R.id.lblInr),
                (TextView)findViewById(R.id.lblAud),
                (TextView)findViewById(R.id.lblCad),
                (TextView)findViewById(R.id.lblZar),
                (TextView)findViewById(R.id.lblNzd),
                (TextView)findViewById(R.id.lblJpy),
                (TextView)findViewById(R.id.lblVND),
        };

        //khởi tạo đối tượng trung chuyển
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_spinner_item,units);
        //Thiết lập cách hiển thị của Spinner
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        //gắn adapter vào spinner
        spnUnits.setAdapter(adapter);


        //Thiết lập hàm sử lý sự kiện thay item được chọn trong Spinner
        spnUnits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                changeMoneyUnit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Thiết lập hàm xử lý sự kiên thay đổi nội dung ô nhập
        txtNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                changeMoneyUnit();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    private String[] units={
            "USD","EUR","GBP","INR","AUD","CAD","ZAR","NZD","JPY","VNĐ"
    };
    private double[][] ratio={
            {1.00000,0.80518,0.64070,63.3318,1.21828,1.16236,11.7129,1.29310,118.337,21385.7},
            {1.24172,1.00000,0.79575,78.6084,1.51266,1.44314,14.5371,1.60576,146.927,26561.8},
            {1.56044,1.25667,1.00000,98.7848,1.90091,1.81355,18.2683,2.01791,184.638,33374.9},
            {0.01580,0.01272,0.01012,1.00000,0.01924,0.01836,0.18493,0.02043,1.86910,337.811},
            {0.82114,0.66119,0.52620,52.0860,1.00000,0.95416,9.61148,1.06158,97.1120,15757.9},
            {0.86059,0.69296,0.55148,54.5885,1.04804,1.00000,10.0732,1.11258,101.777,18401.7},
            {0.08541,0.06877,0.05473,5.40852,0.10398,0.09924,1.00000,0.11037,10.0996,1825.87},
            {0.77402,0.62319,0.49597,49.0031,0.94215,0.89951,9.06754,1.00000,91.5139,16552.1},
            {0.00846,0.00681,0.00542,0.53547,0.01030,0.00983,0.09909,0.01093,1.00000,180.837},
            {0.00005,0.00004,0.00003,0.00296,0.00006,0.00005,0.00055,0.00006,0.00553,1.00000}
    };
    //Hàm đổi đơn vị tiền tệ
    private void changeMoneyUnit(){
        //Lấy vị trí của đơn vị được chọn
        int rowIdx =spnUnits.getSelectedItemPosition();
        if(rowIdx<0)rowIdx=0;
        //Lấy giá trị từ thu nhập
        String input=txtNumber.getText().toString();
        if(input.isEmpty())
            input="0";
        //Đổi giá trị nhập sang số thực
        double number = Double.valueOf(input);
        //Tính giá trị quy đổi tương ứng với từng loại tiền
        for (int i=0;i<lblResults.length;i++){
            double temp = number * ratio[rowIdx][i];
            lblResults[i].setText(String.valueOf(temp));
        }
    }
}