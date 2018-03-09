package com.ahextech.woohooapp.login;


import com.ahextech.woohooapp.APIService;
import com.ahextech.woohooapp.MyApplication;
import com.ahextech.woohooapp.POJO.LoginResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ahextech on 7/3/18.
 */

public class LoginInteractorImpl implements LoginInteractor, Callback<LoginResponseModel> {
    private onAuthCompletedListener listener;

    @Override
    public void authenticateUser(onAuthCompletedListener listener, String email, String password) {
        this.listener = listener;
        APIService apiService = MyApplication.getInstance()
                .getClient().create(APIService.class);
        Call<LoginResponseModel> call = apiService.authenticateUser(email, password);
        call.enqueue(this);
    }

    @Override
    public void validateFields(String email, String password,
                               onValidateFieldListener validateFieldListener) {
        if (email.equals("") || password.equals("")) {
            validateFieldListener.onValidationFailure();
        } else {
            validateFieldListener.onValidationSuccess();
        }
    }

    @Override
    public void onResponse(Call<LoginResponseModel> call, Response<LoginResponseModel> response) {
        if (call.isExecuted()) {
            switch (response.code()) {
                case 200:
                    LoginResponseModel model = response.body();
                    int responseCode = response.code();
                    listener.onAuthSuccess(model);
                    break;
                case 404:
                    listener.onAuthFailure("Status: 404");
                    break;
                case 401:
                    listener.onAuthFailure("Status: 401");
                    break;
                case 500:
                    listener.onAuthFailure("Status: 500");
                    break;
                case 403:
                    listener.onAuthFailure("Status: 403");
                    break;
                case 504:
                    listener.onAuthFailure("Status: 504");
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void onFailure(Call<LoginResponseModel> call, Throwable t) {
        listener.onAuthFailure("Check your internet connection");
    }
}
