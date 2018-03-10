package com.ahextech.woohooapp.signup;

import com.ahextech.woohooapp.POJO.LoginResponseModel;

/**
 * Created by ahextech on 10/3/18.
 */

public class SignUpPresenterImpl implements SignUpPresenter,
        SignUpInteractorImpl.onSignUpCompletedListener, SignUpInteractorImpl.onValidateFieldListener {
    private SignUpView signUpView;
    private SignUpInteractor signUpInteractor;

    public SignUpPresenterImpl(SignUpView signUpView) {
        this.signUpView = signUpView;
        signUpInteractor = new SignUpInteractorImpl();
    }

    @Override
    public void onSignUpButtonClicked(String email, String password, String username) {

    }

    @Override
    public boolean validateLoginFields(String email, String password, String username) {
        return false;
    }

    @Override
    public void onSignUpSuccess(LoginResponseModel model) {

    }

    @Override
    public void onSignUpFailure(String status) {

    }

    @Override
    public void onValidationSuccess() {

    }

    @Override
    public void onValidationFailure() {

    }

    @Override
    public void onPendingValidation(String message) {

    }
}
