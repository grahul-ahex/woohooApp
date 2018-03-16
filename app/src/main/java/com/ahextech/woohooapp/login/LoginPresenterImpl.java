package com.ahextech.woohooapp.login;


import com.ahextech.woohooapp.POJO.LoginResponseModel;

/**
 * Created by ahextech on 7/3/18.
 */

public class LoginPresenterImpl implements LoginPresenterInterface, LoginInteractorImpl.onAuthCompletedListener, LoginInteractorImpl.onValidateFieldListener {
    private LoginView view;
    private LoginInteractor interactor;

    public LoginPresenterImpl(LoginView view) {
        this.view = view;
        interactor = new LoginInteractorImpl();
    }

    @Override
    public void onLoginButtonClicked(String email, String password) {
        view.showProgressDialog();
        interactor.authenticateUser(this, email, password);
    }

    @Override
    public boolean validateLoginFields(String email, String password) {
        boolean isValid = interactor.validateFields(email, password, this);
        return isValid;
    }

    @Override
    public void onAuthSuccess(LoginResponseModel model) {
        view.hideProgressDialog();
        String status = model.getData().getStatus();
        view.onSuccessfulLogin(status);

    }

    @Override
    public void onAuthFailure(String status) {
        view.hideProgressDialog();
        view.onLoginFailure(status);
    }

    @Override
    public void onValidationSuccess() {
        view.hideAlertMessage();
    }

    @Override
    public void onValidationFailure() {
        view.showAlertMessage();
    }

    @Override
    public void onPendingValidation(String message) {
        view.showErrorMessage(message);
    }

}
