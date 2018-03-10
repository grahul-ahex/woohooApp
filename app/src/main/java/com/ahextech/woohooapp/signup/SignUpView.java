package com.ahextech.woohooapp.signup;

/**
 * Created by ahextech on 10/3/18.
 */

public interface SignUpView {
    void showProgressDialog();

    void hideProgressDialog();

    void onSuccessfulRegistration(String status);


    void onRegistrationFailure(String status);

    void hideAlertMessage();

    void showAlertMessage();

    void showErrorMessage(String message);
}
