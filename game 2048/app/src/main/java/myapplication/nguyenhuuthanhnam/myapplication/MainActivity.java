package myapplication.nguyenhuuthanhnam.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
private GridView gdvGamePlay;
private OSoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        khoiTao();
        setData();
    }
    private void anhXa(){
        gdvGamePlay=(GridView)findViewById(R.id.gdvGamePlay);

    }
    private void khoiTao(){
        Datagame.getDatagame().intt(MainActivity.this);
        adapter = new OSoAdapter(MainActivity.this,0,Datagame.getDatagame().getArrSo());

    }
    private void setData(){
        gdvGamePlay.setAdapter(adapter);
    }
}