package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {
    Button btnToast;
    Button btnDialog;
    Button btnThoat;
    Button btnDangNhap;
    TextView txt_taikhoan;
    TextView txt_matkhau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDialog = findViewById(R.id.btnDialog1);
        btnToast = findViewById(R.id.btnToast);
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogLogin();
            }
        });
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogToast();
            }
        });
    }
    private void DialogLogin(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dailog_custom);
        btnThoat = dialog.findViewById(R.id.btnThoat);
        btnDangNhap = dialog.findViewById(R.id.btnDangNhap);
        txt_taikhoan =dialog.findViewById(R.id.txt_taikhoan);
        txt_matkhau =dialog.findViewById(R.id.txt_matkhau);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txt_taikhoan.getText().toString().equals("nam")&& txt_matkhau.getText().toString().equals("123"))
                    Toast.makeText(MainActivity.this,"đã đăng nhập thành công",Toast.LENGTH_LONG).show();

                else {
                    Toast.makeText(MainActivity.this, "đăng nhập thất bại", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    private void DialogToast(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_custom2);
        dialog.show();

    }

}