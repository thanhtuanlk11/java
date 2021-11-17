package myapplication.nguyenhuuthanhnam.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private GridView gdvGamePlay;
private View.OnTouchListener listener;
private float X,Y;
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

        listener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        X=event.getX();
                        Y = event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        if(Math.abs(event.getX()-X)>Math.abs(event.getY()-Y)){
                            if(event.getX()<X){
                                Datagame.getDatagame().vuotTrai();
                                adapter.notifyDataSetChanged();
                            }else{
                                Datagame.getDatagame().vuotPhai();
                                adapter.notifyDataSetChanged();
                            }

                        }else {
                           if(event.getY()>Y){
                               Datagame.getDatagame().vuotLen();
                               adapter.notifyDataSetChanged();
                           }else {
                               Datagame.getDatagame().vuotXuong();
                               adapter.notifyDataSetChanged();
                           }

                        }
                        break;
                }
                return true;
            }
        };

    }
    private void setData(){
        gdvGamePlay.setAdapter(adapter);
        gdvGamePlay.setOnTouchListener(listener);
    }
}