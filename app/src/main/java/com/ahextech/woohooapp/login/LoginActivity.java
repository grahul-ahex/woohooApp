package com.ahextech.woohooapp.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ahextech.woohooapp.R;

public class LoginActivity extends AppCompatActivity implements LoginView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void showLoginButton() {

    }

    @Override
    public void hideLoginButton() {

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void hideProgressDialog() {

    }

    @Override
    public void onSuccessfulLogin(String status) {

    }

    @Override
    public void onLoginFailure(String status) {

    }
}
