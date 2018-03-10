package com.ahextech.woohooapp.signup;

/**
 * Created by ahextech on 10/3/18.
 */

public class SignUpInteractorImpl implements SignUpInteractor {
    @Override
    public void registerUser(onSignUpCompletedListener listener, String email, String password) {

    }

    @Override
    public boolean validateFields(String email, String password, String username, onValidateFieldListener validateFieldListener) {
        return false;
    }
}
