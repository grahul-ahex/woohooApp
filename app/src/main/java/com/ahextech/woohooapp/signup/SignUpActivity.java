package com.ahextech.woohooapp.signup;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahextech.woohooapp.R;
import com.ahextech.woohooapp.ShowProgressDialog;
import com.ahextech.woohooapp.TextWatcherClass;
import com.ahextech.woohooapp.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity implements SignUpView, View.OnClickListener, View.OnTouchListener {
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
    @BindView(R.id.iv_view_password)
    ImageView ivShowPassword;

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
        ivShowPassword.setOnTouchListener(this);
        hideHintViews();

        etUsername.addTextChangedListener(new TextWatcherClass(tvUsername, tvEmailUnavailable));
        etSignUpEmail.addTextChangedListener(new TextWatcherClass(tvSignUpEmail, tvEmailUnavailable));
        etSignUpPassword.addTextChangedListener(new TextWatcherClass(tvSignUpPassowrd, tvEmailUnavailable));

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
        Snackbar.make(tvUsername, status, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onRegistrationFailure(String status) {
        tvEmailUnavailable.setText(status);
        tvEmailUnavailable.setVisibility(View.VISIBLE);
        Snackbar.make(tvUsername, status, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void hideAlertMessage() {
        tvEmailUnavailable.setVisibility(View.INVISIBLE);

    }

    @Override
    public void showAlertMessage() {
        tvEmailUnavailable.setText("Please enter your credentials");
        tvEmailUnavailable.setVisibility(View.VISIBLE);
    }

    @Override
    public void showErrorMessage(String message) {
        tvEmailUnavailable.setText(message);
        tvEmailUnavailable.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sign_up:
                validateFields();
                if (isFieldsValid) {
                    signUpPresenter.onSignUpButtonClicked(email, password, username);
                }
                break;
            case R.id.tv_log_in:
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
        }
    }

    private void validateFields() {
        email = etSignUpEmail.getText().toString();
        password = etSignUpPassword.getText().toString();
        username = etUsername.getText().toString();
        isFieldsValid = signUpPresenter.validateLoginFields(email, password, username);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                etSignUpPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                etSignUpPassword.moveCursorToVisibleOffset();
                etSignUpPassword.setSelection(etSignUpPassword.getText().toString().length());
                break;
            case MotionEvent.ACTION_UP:
                etSignUpPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                break;
        }
        return true;
    }
}
