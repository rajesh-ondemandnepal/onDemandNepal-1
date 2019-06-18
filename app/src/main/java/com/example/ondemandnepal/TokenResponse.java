package com.example.ondemandnepal;

public class TokenResponse {

    public String pushToken;
    public String userId;
    public String deviceInfo;
    public String token;


    public String getPushToken() {
        return pushToken;
    }

    public String getUserId() {
        return userId;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

}
