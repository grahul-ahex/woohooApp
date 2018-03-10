package com.ahextech.woohooapp.signup;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ahextech.woohooapp.R;
import com.ahextech.woohooapp.ShowProgressDialog;
import com.ahextech.woohooapp.TextWatcherClass;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity implements SignUpView, View.OnClickListener {
    @BindView(R.id.tv_email_unavailable)
    TextView tvEmailUnavailable;
    @BindView(R.id.tvUserName)
    TextView tvUsername;
    @BindView(R.id.et_signUp_username)
    EditText etUsername;
    @BindView(R.id.tv_signUP_email)
    TextView tvSignUpEmail;
    @BindView(R.id.et_sign_UpEmail)
    EditText etSignUpEmail;
    @BindView(R.id.tv_SignUpPassword)
    TextView tvSignUpPassowrd;
    @BindView(R.id.et_SignUpPassword)
    EditText etSignUpPassword;
    @BindView(R.id.btn_sign_up)
    Button btnSignUp;
    @BindView(R.id.tv_log_in)
    TextView tvLogIn;

    private SignUpPresenter signUpPresenter;
    private String username, email, password;
    private boolean isFieldsValid;
    private ShowProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        signUpPresenter = new SignUpPresenterImpl(this);
        Typeface typeface = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/chivo_regular.ttf");
        btnSignUp.setTypeface(typeface);
        btnSignUp.setOnClickListener(this);
        tvLogIn.setOnClickListener(this);
        hideHintViews();
        etUsername.addTextChangedListener(new TextWatcherClass(tvUsername));
        etSignUpEmail.addTextChangedListener(new TextWatcherClass(tvSignUpEmail));
        etSignUpPassword.addTextChangedListener(new TextWatcherClass(tvSignUpPassowrd));

    }

    private void hideHintViews() {
        tvUsername.setVisibility(View.INVISIBLE);
        tvSignUpEmail.setVisibility(View.INVISIBLE);
        tvSignUpPassowrd.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showProgressDialog() {
        progressDialog = new ShowProgressDialog(this, "Please wait...");
        progressDialog.showDialog();
    }

    @Override
    public void hideProgressDialog() {
        progressDialog.hideDialog();
    }

    @Override
    public void onSuccessfulRegistration(String status) {

    }

    @Override
    public void onRegistrationFailure(String status) {

    }

    @Override
    public void hideAlertMessage() {

    }

    @Override
    public void showAlertMessage() {

    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sign_up:
                break;
            case R.id.tv_log_in:
                break;
        }
    }
}
