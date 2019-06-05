package com.example.ondemandnepal;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface OnDemandNepalApi {
    @POST("login")
    Call<LoginResponse> login(
            @Body LoginRequest loginRequest
    );

    @POST("user/register")
    Call<UserResponse> register(
           @Body RegisterRequest registerRequest


    );
}
