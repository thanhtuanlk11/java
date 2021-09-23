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

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private EditText txtNumber2;
    private Spinner spnUnits2;
    private TextView[] lblResults2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtNumber2 =(EditText)findViewById(R.id.txtNumber2);
        spnUnits2 =(Spinner)findViewById(R.id.spnUnit2);
        lblResults2 = new TextView[]{
                (TextView)findViewById(R.id.lblHaily),
                (TextView)findViewById(R.id.lblDam),
                (TextView)findViewById(R.id.lblKilometer),
                (TextView)findViewById(R.id.lblLy),
                (TextView)findViewById(R.id.lblMet),
                (TextView)findViewById(R.id.lblYard),
                (TextView)findViewById(R.id.lblFoot),
                (TextView)findViewById(R.id.lblInches),
        };
        //khởi tạo đối tượng trung chuyển

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                MainActivity2.this, android.R.layout.simple_spinner_item,units2);
        //Thiết lập cách hiển thị Spinner
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        //gán adapter vào spinner
        spnUnits2.setAdapter(adapter);

        //Thiết lập hàm xử lý sự kiện thay item được chọn trong Spinner
        spnUnits2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                changeUnit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Thiết lập hàm xử lý sự kiện thay đổi nội dung ô nhập
        txtNumber2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                changeUnit();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    private String[] units2={
        "Hải Lý","Dặm","Kilometer","Lý","Met","Yard","Foot","Inches"
    };
    private double[][] ratio={
            {1.00000000,1.15077945,1.8520000,20.2537183,1852.0000,2025.37183,6076.11549,72913.38583},
            {0.86897624,1.00000000,1.6093440,17.6000000,1609.3440,1760.00000,5280.00000,63360.00000},
            {0.53995680,0.62137119,1.0000000,10.9361330,1000.0000,1093.61330,3280.83990,39370.07874},
            {0.04937365,0.05681818,0.0914400,1.00000000,94.4400,100.00000,300.00000,3600.00000},
            {0.00053996,0.00062137,0.0010000,0.0109361,1.0000,1.09361,3.28084,39.37008},
            {0.00049374,0.00056818,0.0009144,0.0100000,0.9144,1.00000,3.00000,36.00000},
            {0.00016458,0.00018939,0.0003048,0.0033333,0.3048,0.33333,1.00000,12.00000},
            {0.00001371,0.00001578,0.0000254,0.0002778,0.0254,0.02778,0.08333,1.00000},
    };
    //Hàm đổi đơn vị
    private void changeUnit(){
        //Lấy vị trí của đơn vị được chọn
        int rowIdx = spnUnits2.getSelectedItemPosition();
        if(rowIdx<0)rowIdx=0;
        //Lấy giá trị từ thu nhập
        String input =txtNumber2.getText().toString();
        if(input.isEmpty())
            input="0";
        //Đổi giá trị sang số thực
        double number=Double.valueOf(input);
        //Tính giá trị quy đổi tương ứng
        for (int i=0;i<lblResults2.length;i++){
            double temp =number * ratio[rowIdx][i];
            lblResults2[i].setText(String.valueOf(temp));
        }
    }
}