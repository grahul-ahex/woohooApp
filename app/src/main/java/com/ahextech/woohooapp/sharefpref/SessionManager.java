package com.ahextech.woohooapp.sharefpref;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.ahextech.woohooapp.login.LoginActivity;

import java.util.HashMap;

import static com.ahextech.woohooapp.sharefpref.SharefPrefKeys.IS_LOGIN;
import static com.ahextech.woohooapp.sharefpref.SharefPrefKeys.KEY_EMAIL;
import static com.ahextech.woohooapp.sharefpref.SharefPrefKeys.KEY_PASSWORD;
import static com.ahextech.woohooapp.sharefpref.SharefPrefKeys.PREF_NAME;
import static com.ahextech.woohooapp.sharefpref.SharefPrefKeys.PRIVATE_MODE;

/**
 * Created by ahextech on 9/3/18.
 */

public class SessionManager {
    // Context
    private Context context;

    // Shared Preferences
    private SharedPreferences pref;
    // Editor for Shared preferences
    private SharedPreferences.Editor editor;

    // Constructor
    public SessionManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Create login session
     */
    public void createLoginSession(String email, String password) {
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing email in pref
        editor.putString(KEY_EMAIL, email);

        // Storing password in pref
        editor.putString(KEY_PASSWORD, password);

        // commit changes
        editor.commit();
    }

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     */
    public void checkLogin() {
        // Check login status
        if (!this.isLoggedIn()) {
            // user is not logged in redirect him to Login Activity
            redirectUser();
        }

    }


    /**
     * Get stored session data
     */
    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<>();
        // user emailID
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));

        // user password
        user.put(KEY_PASSWORD, pref.getString(KEY_PASSWORD, null));

        // return user
        return user;
    }

    /**
     * Clear session details
     */
    public void logoutUser() {
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();
        // After logout redirect user to Login Activity
        redirectUser();
    }

    /**
     * Quick check for login
     **/
    // Get Login State
    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }

    private void redirectUser() {

        Intent i = new Intent(context, LoginActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(i);
    }

}
