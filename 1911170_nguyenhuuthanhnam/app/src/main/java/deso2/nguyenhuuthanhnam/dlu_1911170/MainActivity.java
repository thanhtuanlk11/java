package deso2.nguyenhuuthanhnam.dlu_1911170;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtX,txtY,txtZ,txtHoVaTen,txtName,txtNhan,txtLuyThua,txtCong;
    Button btnHoTen,btnDongY,btnXoa,btnQuaylai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Unit();
    }
    private void Unit(){
        txtX = findViewById(R.id.txtX);
        txtY = findViewById(R.id.txtY);
        txtZ = findViewById(R.id.txtZ);
        txtHoVaTen = findViewById(R.id.txtHovaTen);
        btnDongY = findViewById(R.id.btnDongY);
        btnHoTen = findViewById(R.id.btnHoTen);
        btnXoa = findViewById(R.id.btnXoa);
        txtName = findViewById(R.id.txtName);
        txtCong = findViewById(R.id.txtCong1);
        txtNhan = findViewById(R.id.txtNhan);
        txtLuyThua = findViewById(R.id.txtluyThua);
        btnQuaylai = findViewById(R.id.btnQuaylai);

        btnHoTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Toast toast = new Toast(MainActivity.this);
                    Toast.makeText(MainActivity.this, txtHoVaTen.getText().toString().trim(), Toast.LENGTH_SHORT).show();

            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtName.getText();
            }
        });
        btnDongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity);
//                btnQuaylai.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        return;
//                    }
//                });
            }

        });



    }
}