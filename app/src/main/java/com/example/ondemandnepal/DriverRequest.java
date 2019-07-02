package com.example.ondemandnepal;

public class DriverRequest {


    private  int id;
    private int vehicleId;
    private String  driverLicense;
    private String status;
    private  int userId;





    public DriverRequest(int id , int vehicleId, String driverLicense , String status, int userId ){

        this.id =5;
        this.vehicleId = vehicleId;
        this.driverLicense = driverLicense;
        this.status = status;
        this.userId = userId;

    }
}


