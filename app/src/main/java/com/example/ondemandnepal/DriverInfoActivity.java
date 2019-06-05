package com.example.ondemandnepal;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class DriverInfoActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_info);
        final EditText date = (EditText) findViewById(R.id.activity_driver_info_Etdatepicker);
        final EditText vehiclemodel = (EditText) findViewById(R.id.activity_driver_info_Etvehicle_model);
        final EditText vehiclereg = (EditText) findViewById(R.id.activity_driver_info_Etvehiclereg);
        final EditText vehiclecolor = (EditText) findViewById(R.id.activity_driver_info_Etcolor);
        final Button submit = (Button) findViewById(R.id.activity_driver_info_Btn_submit);



        date.setOnClickListener(new View.OnClickListener() {

            @Override
        public void onClick(View view) {


        }
        });


        }
    }


