package com.example.ondemandnepal;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {
    Dialog MyDialog;
    Button btnloguser,btnlogdriver ,cross;
    Button btnreguser,btnregdriver ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Button register =(Button) findViewById(R.id.welcome_activity_Btnregister);
        Button login =(Button) findViewById(R.id.welcome_activity_Btnlogin);

        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(WelcomeActivity.this, RegisterActivity.class);
                startActivity(intent);

               // MyCustomAlertDialogregister();
            }
        });


        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
              //MyCustomAlertDialoglogin();
            }
        });


    }

    public void MyCustomAlertDialoglogin(){
        MyDialog = new Dialog(WelcomeActivity.this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.custom_popup_login);
        MyDialog.setTitle("My Custom Dialog");
        btnloguser = (Button)MyDialog.findViewById(R.id.custom_popup_login_Btnuser);
        btnlogdriver = (Button)MyDialog.findViewById(R.id.custom_popup_login_Btndriver);
        btnloguser.setEnabled(true);
        btnlogdriver.setEnabled(true);
        btnloguser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(getApplicationContext(), " Custom Alert Dialog", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        btnlogdriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  MyDialog.cancel();
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        MyDialog.show();
    }


    /*public void MyCustomAlertDialogregister(){
        MyDialog = new Dialog(WelcomeActivity.this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.custom_popup_login);
        MyDialog.setTitle("My Custom Dialog");
        btnreguser = (Button)MyDialog.findViewById(R.id.custom_popup_register_Btnuser);
        btnregdriver = (Button)MyDialog.findViewById(R.id.custom_popup_register_Btndriver);
        //btnreguser.setEnabled(true);
       // btnregdriver.setEnabled(true);
        btnreguser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Toast.makeText(getApplicationContext(), " Custom Alert Dialog", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(WelcomeActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        btnregdriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  MyDialog.cancel();
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        MyDialog.show();
    }*/

}
