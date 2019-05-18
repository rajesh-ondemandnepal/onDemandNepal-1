package com.example.ondemandnepal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        Button register =(Button) findViewById(R.id.register_activity_Btnregister);
        EditText email =(EditText)findViewById(R.id.register_activity_Etemail);
        EditText password =(EditText)findViewById(R.id.register_activity_Etpassword);
        EditText firstname =(EditText)findViewById(R.id.register_activity_ETfirstname);
        EditText lastname =(EditText)findViewById(R.id.register_activity_Etlastname);
        EditText mobile =(EditText)findViewById(R.id.register_activity_Etmobile);
        EditText CountryExt =(EditText)findViewById(R.id.register_activity_EtmobileExt);


        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }

}
