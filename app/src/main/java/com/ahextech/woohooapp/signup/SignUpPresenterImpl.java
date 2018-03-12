package com.ahextech.woohooapp.signup;

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
        signUpView.showProgressDialog();
        signUpInteractor.registerUser(this, email, password, username);
    }

    @Override
    public boolean validateLoginFields(String email, String password, String username) {
        boolean isValid = signUpInteractor.validateFields(email, password, username, this);
        return isValid;
    }

    @Override
    public void onSignUpSuccess() {
        signUpView.hideProgressDialog();
        signUpView.onSuccessfulRegistration("Registration Successful");
    }

    @Override
    public void onSignUpFailure(String status) {
        signUpView.hideProgressDialog();
        signUpView.onRegistrationFailure(status);
    }

    @Override
    public void onValidationSuccess() {
        signUpView.hideAlertMessage();
    }

    @Override
    public void onValidationFailure() {
        signUpView.showAlertMessage();
    }

    @Override
    public void onPendingValidation(String message) {
        signUpView.showErrorMessage(message);
    }
}
