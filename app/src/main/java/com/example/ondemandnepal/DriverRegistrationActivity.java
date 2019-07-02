package com.example.ondemandnepal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DriverRegistrationActivity extends AppCompatActivity  {


    private EditText driverLicense,status;
     EditText mvehicleId ,muserId;
   int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_registration);

        final EditText mvehicleId = (EditText) findViewById(R.id.activity_driver_registration_Etvehicle_Id);
        final EditText driverLicense = (EditText) findViewById(R.id.activity_driver_registration_EtdriverLicense);
        final EditText status = (EditText) findViewById(R.id.activity_driver_registration_Etstatus);
       final EditText muserId = (EditText) findViewById(R.id.activity_driver_registration_EtuserId);
        final Button submit = (Button) findViewById(R.id.activity_driver_registration_Btn_submit);


        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                registerDriver();

            }
        });


        }
    private void registerDriver() {
        OnDemandNepalApi onDemandNepalApi = NetworkServices.getInstance().getClient();


        String driverLicense = this.driverLicense.getText().toString();
        String status = this.status.getText().toString();
        int userId = Integer.parseInt(muserId.getText().toString());
        int vehicleId = Integer.parseInt(mvehicleId.getText().toString());
        //int vehicleId = Integer.decode(mvehicleId.getText().toString()).intValue();

        Call<DriverResponse> driverRegister = onDemandNepalApi.driverRegister(new DriverRequest( id ,vehicleId,driverLicense,status,userId));

      driverRegister.enqueue(new Callback<DriverResponse>() {
            @Override
            public void onResponse(Call<DriverResponse> call, Response<DriverResponse> response) {
                //success
                response.body();
                /*Intent intent = new Intent(RegisterActivity.this, DriverRegistrationActivity.class);
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


