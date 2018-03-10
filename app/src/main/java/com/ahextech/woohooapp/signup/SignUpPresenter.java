package com.ahextech.woohooapp.signup;

/**
 * Created by ahextech on 10/3/18.
 */

public interface SignUpPresenter {
    void onSignUpButtonClicked(String email, String password,String username);

    boolean validateLoginFields(String email, String password,String username);
}
