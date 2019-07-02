
package com.example.ondemandnepal;

        import android.os.Bundle;
        import androidx.appcompat.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;

public class VehicleRegistration  extends AppCompatActivity  {
    String created,updated;
    private EditText make,model,registrationNum,color ,year;
    int id ,driverId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_registration);

       

         make = findViewById(R.id.activity_vehicle_registration_Etvehicle_make);
         model = findViewById(R.id.activity_vehicle_registration_Etvehicle_model);
        registrationNum = findViewById(R.id.activity_vehicle_registration_Etvehiclereg);
        color =  findViewById(R.id.activity_vehicle_registration_Etcolor);
        year =  findViewById(R.id.activity_vehicle_registration_Etdatepicker);
        final Button submit = (Button) findViewById(R.id.activity_vehicle_registration_Btn_submit);




        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                registerVehicle();

            }
        });


    }
    private void registerVehicle() {
        OnDemandNepalApi onDemandNepalApi = NetworkServices.getInstance().getClient();
        // String id = this.id.getEditText().getText().toString();
        String make = this.make.getText().toString();
        String model = this.model.getText().toString();
        String year = this.year.getText().toString();
        String color = this.color.getText().toString();
        String registrationNum = this.registrationNum.getText().toString();


        Call<VehicleResponse> vehicleRegister = onDemandNepalApi.vehicleRegister(new VehicleRequest( id , make, model ,year, color ,registrationNum ,driverId,created,updated));


        vehicleRegister.enqueue(new Callback<VehicleResponse>() {
            @Override
            public void onResponse(Call<VehicleResponse> call, Response<VehicleResponse> response) {
                //success
                response.body();
                /*Intent intent = new Intent(RegisterActivity.this, DriverRegistrationActivity.class);
                startActivity(intent);*/
            }

            @Override
            public void onFailure(Call<VehicleResponse> call, Throwable t) {
                //failure
                t.printStackTrace();
            }
        });


    }
}


