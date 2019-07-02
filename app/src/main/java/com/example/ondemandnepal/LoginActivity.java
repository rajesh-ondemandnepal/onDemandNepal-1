package com.example.ondemandnepal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");

    private TextInputLayout email;
    private TextInputLayout password;
    private Button login;
    private TextView notRegister,forgetPassword ,addDriver,addVehicle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        email = findViewById(R.id.login_activity_Etemail);
        password = findViewById(R.id.login_activity_Etpassword);
        login =findViewById(R.id.login_activity_Btnlogin);
       // notRegister=findViewById(R.id.login_activity_Tvnotregister);
        forgetPassword= findViewById(R.id.login_activity_Tvforgetpassword);
       // addDriver= findViewById(R.id.login_activity_Tv_add_driver);
       // addVehicle= findViewById(R.id.login_activity_Tv_add_vehicle);

       /* notRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

               *//* Intent intent = new Intent(LoginActivity.this, RouteNavigationActivity.class);
                startActivity(intent);
                finish();*//*

               Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);

            }
        });


        addDriver.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

               *//* Intent intent = new Intent(LoginActivity.this, RouteNavigationActivity.class);
                startActivity(intent);
                finish();*//*

                Intent intent = new Intent(LoginActivity.this, DriverRegistrationActivity.class);
                startActivity(intent);

            }
        });

        addVehicle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

               *//* Intent intent = new Intent(LoginActivity.this, RouteNavigationActivity.class);
                startActivity(intent);
                finish();*//*

                Intent intent = new Intent(LoginActivity.this, VehicleRegistration.class);
                startActivity(intent);

            }
        });
*/

        forgetPassword.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Token: "  ,Toast.LENGTH_SHORT)
                        .show();

            }
        });

            login.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (validateEmail()) {
                        loginUser();
                    }
                }
            });
    }

    private void loginUser() {
        OnDemandNepalApi onDemandNepalApi = NetworkServices.getInstance().getClient();
        String email = this.email.getEditText().getText().toString();
        String password = this.password.getEditText().getText().toString();
        Call<LoginResponse> login = onDemandNepalApi.login(new LoginRequest(email, password));


        login.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                //success
                response.body();
                Intent intent = new Intent(LoginActivity.this, MapsActivity.class);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                //failure
                t.printStackTrace();
            }
        });
    }

    private boolean validateEmail() {
        String emailInput = email.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            email.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            email.setError("Please enter a valid email address");
            return false;
        } else {
            email.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = password.getEditText().getText().toString().trim();

        if (passwordInput.isEmpty()) {
            password.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            password.setError("Password too weak");
            return false;
        } else {
            password.setError(null);
            return true;
        }
    }

}
