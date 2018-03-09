package com.ahextech.woohooapp.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ahextech on 28/2/18.
 */

public class LoginResponseModel {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("twilioToken")
    @Expose
    private String twilioToken;
    @SerializedName("twilioRoomName")
    @Expose
    private String twilioRoomName;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTwilioToken() {
        return twilioToken;
    }

    public void setTwilioToken(String twilioToken) {
        this.twilioToken = twilioToken;
    }

    public String getTwilioRoomName() {
        return twilioRoomName;
    }

    public void setTwilioRoomName(String twilioRoomName) {
        this.twilioRoomName = twilioRoomName;
    }
}
