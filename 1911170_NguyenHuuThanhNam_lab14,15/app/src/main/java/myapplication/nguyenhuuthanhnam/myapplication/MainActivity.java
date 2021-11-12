package myapplication.nguyenhuuthanhnam.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final String SAVE_PREF = "save_pref";
    SQLiteHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitialDB();
        gotoLoginScreen();
    }
    public void gotoRegisterScreen() {
        getSupportFragmentManager().beginTransaction().replace(R.id.ln_main, new
                M001RegisterFragment()).commit();
    }
    public void gotoLoginScreen() {
        getSupportFragmentManager().beginTransaction().replace(R.id.ln_main, new
                M000LoginFragment()).commit();
    }
    private  void InitialDB(){
        helper = new SQLiteHelper(this);
        helper.openDB();
        helper.createTable();
    }
}