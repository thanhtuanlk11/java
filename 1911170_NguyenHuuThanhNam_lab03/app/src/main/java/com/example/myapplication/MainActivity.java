package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;
import android.content.pm.ActivityInfo;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {

    ToggleButton btnOnOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m004_act_face);
        init();
//        init1();

    }
    private void init1(){
                btnOnOff=  findViewById(R.id.btn_OnOff);
        btnOnOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (btnOnOff.isChecked()) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                } else {
                    setRequestedOrientation((ActivityInfo.SCREEN_ORIENTATION_FULL_USER));

                }
            }
        });
    }


    TextView txtHi;
    EditText edtEmail;
    EditText edtPassword;
    Button btnLogin;
    TextView txtRegister;
    TextView VN;
    TextView EN;
    TextView FA;


    private void init() {
        txtHi = findViewById(R.id.Hello);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        txtRegister = findViewById(R.id.txtRegister);
        VN = findViewById(R.id.VN);
        EN = findViewById(R.id.EN);
        FA = findViewById(R.id.FA);
        EN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtHi.setText("Welcome");
                edtEmail.setText("Email Address");
                edtPassword.setText("Password");
                btnLogin.setText("LOGIN");
                txtRegister.setText("Don't have account?Sign Up");
            }
        });
        FA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtHi.setText("accueil");
                edtEmail.setText("adresse e-mail");
                edtPassword.setText("mot de passe");

                btnLogin.setText("CONNEXION");
                txtRegister.setText("Ne pas avoir un compte? signer");
            }
        });
        VN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtHi.setText("Xin chào");
                edtEmail.setText("Email");
                edtPassword.setText("Mật khẩu");
                btnLogin.setText("Đăng nhập");
                txtRegister.setText("Không có tài khoản. Vui lòng đăng ký");
            }
        });
    }

}