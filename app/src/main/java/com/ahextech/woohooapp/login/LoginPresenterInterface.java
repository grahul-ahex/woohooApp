package com.ahextech.woohooapp.login;

/**
 * Created by ahextech on 7/3/18.
 */

public interface LoginPresenterInterface {
    void onLoginButtonClicked(String email, String password);

    boolean validateLoginFields(String email, String password);

}
