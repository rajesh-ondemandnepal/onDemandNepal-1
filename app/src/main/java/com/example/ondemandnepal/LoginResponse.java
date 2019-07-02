package com.example.ondemandnepal;

import com.example.ondemandnepal.model.User;

class LoginResponse {
    public User user ;
    public String token;


    public String getToken() {
        return token;
    }

    public User getUser() {
        return user;
    }
}
