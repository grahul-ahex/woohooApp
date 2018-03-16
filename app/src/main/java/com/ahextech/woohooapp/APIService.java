package com.ahextech.woohooapp;


import com.ahextech.woohooapp.POJO.LoginResponseModel;
import com.ahextech.woohooapp.POJO.RegistrationReponseModel;
import com.ahextech.woohooapp.POJO.UserNameAvailabilityResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by ahextech on 7/3/18.
 */

public interface APIService {

    @FormUrlEncoded
    @POST("/apiv2/session")
    Call<LoginResponseModel> authenticateUser(@Field("email") String email,
                                              @Field("password") String password);

    @FormUrlEncoded
    @POST("/apiv2/user/")
    Call<RegistrationReponseModel> registerUser(@Field("email") String email,
                                                @Field("password") String password,
                                                @Field("name") String username);


    @FormUrlEncoded
    @POST("/apiv2/woohoo/email")
    Call<UserNameAvailabilityResponse> checkUserNameAvailability(@Field("email") String email);

}
