package com.ahextech.woohooapp.login;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ahextech.woohooapp.R;
import com.ahextech.woohooapp.ShowProgressDialog;
import com.ahextech.woohooapp.TextWatcherClass;
import com.ahextech.woohooapp.signup.SignUpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {
    @BindView(R.id.tv_email)
    TextView tvEmail;
    @BindView(R.id.et_signUpEmail)
    EditText etEmail;
    @BindView(R.id.tv_LoginPassword)
    TextView tvPassword;
    @BindView(R.id.et_LoginPassword)
    EditText etPassword;
    @BindView(R.id.btn_log_in)
    Button btnLogin;
    @BindView(R.id.tv_sign_up)
    TextView tvSignUp;
    @BindView(R.id.tv_alert)
    TextView tvAlert;

    private LoginPresenterImpl loginPresenter;

    private String email, password;

    private ShowProgressDialog progressDialog;
    private boolean isTextFieldsValid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenterImpl(this);
        Typeface typeface = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/chivo_regular.ttf");
        btnLogin.setTypeface(typeface);
        btnLogin.setOnClickListener(this);
        tvSignUp.setOnClickListener(this);
        hideHintViews();
        etEmail.addTextChangedListener(new TextWatcherClass(tvEmail));
        etPassword.addTextChangedListener(new TextWatcherClass(tvPassword));
    }

    private void hideHintViews() {
        tvEmail.setVisibility(View.INVISIBLE);
        tvPassword.setVisibility(View.INVISIBLE);
    }


    private void validateFields() {
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();
        isTextFieldsValid = loginPresenter.validateLoginFields(email, password);

    }


    @Override
    public void showProgressDialog() {
        progressDialog = new ShowProgressDialog(this, "Authenticating");
        progressDialog.showDialog();
    }

    @Override
    public void hideProgressDialog() {
        progressDialog.hideDialog();
    }

    @Override
    public void onSuccessfulLogin(String status) {
        Snackbar.make(etEmail, status, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailure(String status) {
        if (status.equalsIgnoreCase(getResources().getString(R.string.internetConnection))) {
            Snackbar.make(etEmail, status, Snackbar.LENGTH_SHORT).show();

        } else {
            final Dialog errorDialog = new Dialog(this);
            errorDialog.setContentView(R.layout.alert_dialog);
            errorDialog.setCanceledOnTouchOutside(false);
            errorDialog.setCancelable(false);

            Button btn = errorDialog.findViewById(R.id.btn_try_again);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    errorDialog.dismiss();
                }
            });
            errorDialog.show();
        }
    }

    @Override
    public void hideAlertMessage() {
        tvAlert.setVisibility(View.GONE);
    }

    @Override
    public void showAlertMessage() {
        tvAlert.setVisibility(View.VISIBLE);

    }

    @Override
    public void showErrorMessage(String message) {
        tvAlert.setText(message);
        tvAlert.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_log_in:
                validateFields();
                if (isTextFieldsValid) {
                    loginPresenter.onLoginButtonClicked(email, password);
                }
                break;
            case R.id.tv_sign_up:
                startActivity(new Intent(this, SignUpActivity.class));
                break;
        }
    }
}
