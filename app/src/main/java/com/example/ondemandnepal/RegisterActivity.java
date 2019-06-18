package com.example.ondemandnepal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

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
    private TextInputLayout password ,confirmpassword;
     private EditText id, firstName ,lastName,mobile;
     Double lat ,lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        Button register =(Button) findViewById(R.id.register_activity_Btnregister);
        email =findViewById(R.id.register_activity_Etemail);
        password =findViewById(R.id.register_activity_Etpassword);
        confirmpassword =findViewById(R.id.register_activity_EtConformpassword);
        firstName = findViewById(R.id.register_activity_ETfirstname);
        lastName =findViewById(R.id.register_activity_Etlastname);
        mobile =findViewById(R.id.register_activity_Etmobile);
        TextView alreadylogin = (TextView)findViewById(R.id.register_activity_Btnalreadylogin);


        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (validateEmail()) {
                    registerUser();
                }

              // registerUser();
            }
        });

        alreadylogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    private void registerUser() {
        OnDemandNepalApi onDemandNepalApi = NetworkServices.getInstance().getClient();
       // String id = this.id.getEditText().getText().toString();
        String lastName = this.lastName.getText().toString();
        String firstName = this.firstName.getText().toString();
        String email = this.email.getEditText().getText().toString();
        String mobile = this.mobile.getText().toString();
        String password = this.password.getEditText().getText().toString();

        Call<UserResponse> register = onDemandNepalApi.register(new RegisterRequest( null,firstName,lastName ,email,password ,lat,lng));


       register.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                //success
                response.body();
                  Intent intent = new Intent(RegisterActivity.this, DriverInfoActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
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
  //  if(password.getText().toString().equals(confirmpassword.getText().toString()))




}
