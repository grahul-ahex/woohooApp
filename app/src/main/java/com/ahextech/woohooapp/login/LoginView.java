package com.ahextech.woohooapp.login;

/**
 * Created by ahextech on 7/3/18.
 */

public interface LoginView {


    void showProgressDialog();

    void hideProgressDialog();

    void onSuccessfulLogin(String status);


    void onLoginFailure(String status);

    void hideAlertMessage();

    void showAlertMessage();

    void showErrorMessage(String message);
}
