package com.example.myapplication;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class MainActicity3 extends AppCompatActivity {
    TextView txtLogin;
    TextView txtEmail;
    TextView txtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m001_act_login);
        initControl();
    }
    private void initControl(){
        txtLogin = findViewById(R.id.txtLogin);
        txtEmail =findViewById(R.id.txtEmail);
        txtPassword =findViewById(R.id.txtPassword);
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(MainActicity3.this);
                LayoutInflater inflater = getLayoutInflater();
                View view =inflater.inflate(R.layout.layout_custom_toast,(ViewGroup) findViewById(R.id.layout_custom_toast));
                TextView tvMessage = view.findViewById(R.id.tv_message);
                tvMessage.setText("Đăng Nhập thành công"+"\n"+"Email: "+txtEmail.getText()+'\n'+"mật khẩu : "+txtPassword.getText());
                toast.setView(view);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

}
