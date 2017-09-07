package com.task.efishery.tryandroidmvp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.task.efishery.tryandroidmvp.models.LuasModel;
import com.task.efishery.tryandroidmvp.presenters.LoginPresenter;
import com.task.efishery.tryandroidmvp.presenters.LuasPresenter;
import com.task.efishery.tryandroidmvp.views.LoginContract;
import com.task.efishery.tryandroidmvp.views.LuasView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements LoginContract.LoginView,LuasView {

    private LoginPresenter loginPresenter;
    private LuasPresenter luasPresenter;
    private int panjang;
    private int lebar;

    @BindView(R.id.et_username)
    EditText etUsername;

    @BindView(R.id.et_password)
    EditText etPassword;

    @BindView(R.id.et_panjang)
    EditText etPanjang;

    @BindView(R.id.et_lebar)
    EditText etLebar;

    @BindView(R.id.bt_login)
    Button btLogin;

    @OnClick(R.id.bt_login)
    void loginClicked() {
        loginPresenter.doLogin(etUsername.getText().toString(),etPassword.getText().toString());
    }

    @OnClick(R.id.bt_hitung_luas)
    void luasClicked() {
        panjang = Integer.valueOf(etPanjang.getText().toString());
        lebar = Integer.valueOf(etLebar.getText().toString());
        luasPresenter.hitungLuas(panjang,lebar);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter(this);
        luasPresenter = new LuasPresenter(this);
    }

    @Override
    public void loginSuccess(String title) {
        btLogin.setText(title);
        etUsername.setText("");
        etPassword.setText("");
    }

    @Override
    public void logout(String title) {
        btLogin.setText(title);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void tampilkanLuas(LuasModel model) {
        new AlertDialog.Builder(MainActivity.this).setTitle("Luas").setMessage(String.valueOf(model.getLuas())).show();
    }

    @Override
    protected void onDestroy() {
        loginPresenter.detachView();
        luasPresenter.detachView();
        super.onDestroy();
    }

}
