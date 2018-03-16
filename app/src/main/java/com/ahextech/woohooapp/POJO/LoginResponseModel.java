package com.ahextech.woohooapp.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ahextech on 28/2/18.
 */

public class LoginResponseModel {
    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("user_id")
        @Expose
        private String userID;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("session_token")
        @Expose
        private String token;
        @SerializedName("refresh_token")
        @Expose
        private String refreshToken;

        @SerializedName("expiry_time")
        @Expose
        private String expiryTime;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getUserID() {
            return userID;
        }

        public void setUserID(String userID) {
            this.userID = userID;
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

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public String getExpiryTime() {
            return expiryTime;
        }

        public void setExpiryTime(String expiryTime) {
            this.expiryTime = expiryTime;
        }
    }
}
