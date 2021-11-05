package myapplication.nguyenhuuthanhnam.myapplication;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
public class M000LoginFragment  extends Fragment implements View.OnClickListener{
    private EditText edtEmail, edtPass;
    private Context mContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.m000_frg_login, container, false);
        initView(rootView);
        return rootView;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }
    private void initView(View v) {
        edtEmail = v.findViewById(R.id.edt_email);
        edtPass = v.findViewById(R.id.edt_pass);
        v.findViewById(R.id.tv_login).setOnClickListener(this);
        v.findViewById(R.id.tv_register).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(mContext,
                androidx.appcompat.R.anim.abc_fade_in));
        if (v.getId() == R.id.tv_login) {
            login(edtEmail.getText().toString(), edtPass.getText().toString());
        } else if (v.getId() == R.id.tv_register) {
            gotoRegisterScreen();
        }
    }
    private void gotoRegisterScreen() {
        ((MainActivity) mContext).gotoRegisterScreen();
    }
    private void login(String mail, String pass) {
        if (mail.isEmpty() || pass.isEmpty()) {
            Toast.makeText(mContext, "Empty value", Toast.LENGTH_SHORT).show();
            return;
        }
        SharedPreferences pref = mContext.getSharedPreferences(MainActivity.SAVE_PREF,
                Context.MODE_PRIVATE);
        String savedPass = pref.getString(mail, null);
        if (savedPass == null) {
            Toast.makeText(mContext, "Email is not existed!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!pass.equals(savedPass)) {
            Toast.makeText(mContext, "Password is not correct!", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(mContext, "Login account successfully!", Toast.LENGTH_SHORT).show();
    }
}
