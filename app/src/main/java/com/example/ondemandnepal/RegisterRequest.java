package com.example.ondemandnepal;

public class RegisterRequest {
    private  String id;
    private String firstName;
    private String lastName;
    private String email;
    private  String mobile;
    private String password;
    private Double lat;
    private Double lng;


    public RegisterRequest( String id ,String firstName,String lastName ,String email, String password , Double lat ,Double lng ){

        this.id =id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.lat = 12.12;
        this.lng = 14.14;
    }
}
