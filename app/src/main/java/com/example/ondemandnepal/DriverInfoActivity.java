package com.example.ondemandnepal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DriverInfoActivity extends AppCompatActivity  {
    String created,updated;
    private EditText make,model,registrationNum,color ,year;
   int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_info);

        final EditText make = (EditText) findViewById(R.id.activity_driver_info_Etvehicle_make);
        final EditText model = (EditText) findViewById(R.id.activity_driver_info_Etvehicle_model);
        final EditText registrationNum = (EditText) findViewById(R.id.activity_driver_info_Etvehiclereg);
        final EditText color = (EditText) findViewById(R.id.activity_driver_info_Etcolor);
        final EditText year = (EditText) findViewById(R.id.activity_driver_info_Etdatepicker);
        final Button submit = (Button) findViewById(R.id.activity_driver_info_Btn_submit);



        make.setOnClickListener(new View.OnClickListener() {

            @Override
        public void onClick(View view) {


        }
        });

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                registerUser();

            }
        });


        }
    private void registerUser() {
        OnDemandNepalApi onDemandNepalApi = NetworkServices.getInstance().getClient();
        // String id = this.id.getEditText().getText().toString();
        String make = this.make.getText().toString();
        String model = this.model.getText().toString();
        String year = this.year.getText().toString();
        String color = this.color.getText().toString();
        String registrationNum = this.registrationNum.getText().toString();


        Call<DriverResponse> driverRegister = onDemandNepalApi.driverRegister(new DriverRequest( id , make, model ,year, color ,registrationNum ,created,updated));


      driverRegister.enqueue(new Callback<DriverResponse>() {
            @Override
            public void onResponse(Call<DriverResponse> call, Response<DriverResponse> response) {
                //success
                response.body();
                /*Intent intent = new Intent(RegisterActivity.this, DriverInfoActivity.class);
                startActivity(intent);*/
            }

            @Override
            public void onFailure(Call<DriverResponse> call, Throwable t) {
                //failure
                t.printStackTrace();
            }
        });


    }
    }


