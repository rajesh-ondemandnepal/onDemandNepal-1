package com.example.ondemandnepal;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class User {
    @SerializedName("id")
    private  String id;
    @SerializedName("firstName")
    private  String firstName;
    @SerializedName("lastName")
    private  String lastName;
    @SerializedName("email")
    private  String email;
    @SerializedName("password")
    private  String password;
    @SerializedName("mobile")
    private  String mobile;

    public User(String id, String firstName,String lastName, String email,String mobile,
                String password){
                this.id =id;
                this.email =email;
                this.firstName = firstName;
                this.lastName =lastName;
                this.password = password;
                this.mobile =mobile;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
