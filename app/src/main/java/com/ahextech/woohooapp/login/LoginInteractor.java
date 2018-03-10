package com.ahextech.woohooapp.login;


import com.ahextech.woohooapp.POJO.LoginResponseModel;

/**
 * Created by ahextech on 7/3/18.
 */

public interface LoginInteractor {

    void authenticateUser(onAuthCompletedListener listener, String email, String password);

    boolean validateFields(String email, String password, onValidateFieldListener validateFieldListener);

    interface onAuthCompletedListener {
        void onAuthSuccess(LoginResponseModel model);

        void onAuthFailure(String status);

    }

    interface onValidateFieldListener {

        void onValidationSuccess();

        void onValidationFailure();
        void onPendingValidation(String message);

    }
}
