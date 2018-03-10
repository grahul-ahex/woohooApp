package com.ahextech.woohooapp.signup;

import com.ahextech.woohooapp.POJO.LoginResponseModel;

/**
 * Created by ahextech on 10/3/18.
 */

public interface SignUpInteractor {
    void registerUser(onSignUpCompletedListener listener, String email, String password);

    boolean validateFields(String email, String password, String username, onValidateFieldListener validateFieldListener);

    interface onSignUpCompletedListener {
        void onSignUpSuccess(LoginResponseModel model);

        void onSignUpFailure(String status);

    }

    interface onValidateFieldListener {

        void onValidationSuccess();

        void onValidationFailure();

        void onPendingValidation(String message);

    }
}
