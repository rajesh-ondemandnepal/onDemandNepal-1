package com.example.ondemandnepal;

public class VehicleRequest {

        private  int id;
        private String make;
        private String model;
        private String year;
        private  String color;
        private String registrationNum;
        private int driverId;
        private String created;
        private String updated;





        public VehicleRequest(int id , String make, String model , String year, String color , String registrationNum,int driverId, String created, String updated ){

            this.id =5;
            this.make = make;
            this.model = model;
            this.year = year;
            this.color = color;
            this.registrationNum = registrationNum;
            this.driverId= 123;
            // ---- ****  ----//
            this.created = "created";
            this.updated = "updated";
        }
    }


