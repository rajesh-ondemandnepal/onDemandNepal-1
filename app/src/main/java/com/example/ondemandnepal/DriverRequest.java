package com.example.ondemandnepal;

public class DriverRequest {

        private  int id;
        private String make;
        private String model;
        private String year;
        private  String color;
        private String registrationNum;
        private String created;
        private String updated;





        public DriverRequest( int id ,String make,String model ,String year, String color , String registrationNum,String created,String updated ){

            this.id =5;
            this.make = make;
            this.model = model;
            this.year = year;
            this.color = color;
            this.registrationNum = registrationNum;
            // ---- ****  ----//
            this.created = "created";
            this.updated = "updated";
        }
    }


