package com.ahextech.woohooapp.signup;

import com.ahextech.woohooapp.APIService;
import com.ahextech.woohooapp.MyApplication;
import com.ahextech.woohooapp.POJO.RegistrationReponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ahextech on 10/3/18.
 */

public class SignUpInteractorImpl implements SignUpInteractor, Callback<RegistrationReponseModel> {
    onSignUpCompletedListener listener;
    String email;

    @Override
    public void registerUser(onSignUpCompletedListener listener, String email, String password, String username) {
        this.listener = listener;
        this.email = email;
        Call<RegistrationReponseModel> call =
                MyApplication.getInstance()
                        .getClient().create(APIService.class).registerUser(email, password, username);
        call.enqueue(this);
    }

    @Override
    public boolean validateFields(String email, String password, String username,
                                  onValidateFieldListener validateFieldListener) {

        boolean isValid;
        if (email.equals("") && password.equals("") && username.equals("")) {
            validateFieldListener.onValidationFailure();
            isValid = false;
        } else if (email.equals("")) {
            validateFieldListener.onPendingValidation("Please enter your email");
            isValid = false;
        } else if (password.equals("")) {
            validateFieldListener.onPendingValidation("Please enter your password");
            isValid = false;
        } else if (username.equals("")) {
            validateFieldListener.onPendingValidation("Please enter your username");
            isValid = false;
        } else {
            if (email.contains("@woohoo.com")) {
                validateFieldListener.onValidationSuccess();
                isValid = true;
            } else {
                validateFieldListener.onPendingValidation("Incorrect email");
                isValid = false;
            }
        }
        return isValid;
    }

    @Override
    public void onResponse(Call<RegistrationReponseModel> call, Response<RegistrationReponseModel> response) {
        if (call.isExecuted()) {
            int resposeCode = response.code();
            switch (resposeCode) {
                case 200://Request Successful
                    listener.onSignUpSuccess();
                    break;
                case 400://Bad Request
                    listener.onSignUpFailure(email +" "+ "is already taken.Try another");
                    break;
                case 422://validation error
                    listener.onSignUpFailure("Validation Error");
                    break;

                case 500://internal server error
                    listener.onSignUpFailure("Internal Server Error");

                    break;
                case 403:// forbidden
                    listener.onSignUpFailure("Forbidden");

                    break;
            }
        }
    }

    @Override
    public void onFailure(Call<RegistrationReponseModel> call, Throwable t) {

    }
}
