package com.ahextech.woohooapp.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ahextech on 9/3/18.
 */

public class UserNameAvailabilityResponse {
    @SerializedName("status")
    @Expose
    String status;
    @SerializedName("message")
    @Expose
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
