package com.ahextech.woohooapp;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by ahextech on 9/3/18.
 */

public class ShowProgressDialog {
    private Context context;
    private String message;
    private ProgressDialog dialog;

    public ShowProgressDialog(Context context, String message) {
        this.context = context;
        this.message = message;
    }

    public void showDialog() {
        dialog = new ProgressDialog(context, R.style.AppTheme_Dark_Dialog);
        dialog.setMessage(message);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setIndeterminate(true);
        dialog.setCancelable(true);
        dialog.show();
    }

    public void hideDialog() {
        dialog.dismiss();
    }
}
