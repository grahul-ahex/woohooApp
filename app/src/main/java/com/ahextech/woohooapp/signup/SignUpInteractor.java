package com.ahextech.woohooapp.signup;

/**
 * Created by ahextech on 10/3/18.
 */

public interface SignUpInteractor {
    void registerUser(onSignUpCompletedListener listener,
                      String email, String password, String username);

    boolean validateFields(String email, String password,
                           String username, onValidateFieldListener validateFieldListener);

    interface onSignUpCompletedListener {
        void onSignUpSuccess();

        void onSignUpFailure(String status);

    }

    interface onValidateFieldListener {

        void onValidationSuccess();

        void onValidationFailure();

        void onPendingValidation(String message);

    }
}
