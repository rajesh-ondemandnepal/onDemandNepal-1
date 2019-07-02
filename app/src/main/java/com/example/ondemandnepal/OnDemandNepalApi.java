package com.example.ondemandnepal;

import retrofit2.Call;
import retrofit2.http.Body;
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


    @POST("driver/register")
    Call<DriverResponse> driverRegister(
            @Body DriverRequest driverRequest
    );

    @POST("vehicle")
    Call<VehicleResponse> vehicleRegister(
            @Body VehicleRequest vehicleRequest
    );

    @POST("push")
    Call<TokenResponse> tokenRegister(
            @Body TokenRequest tokenRequest
    );


}
