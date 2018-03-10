package com.ahextech.woohooapp;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

/**
 * Created by ahextech on 10/3/18.
 */

public class TextWatcherClass implements TextWatcher {

    private View view;

    public TextWatcherClass(View view) {
        this.view = view;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s.length() == 0) {
            view.setVisibility(View.INVISIBLE);
        } else {
            view.setVisibility(View.VISIBLE);
            view.animate();
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
