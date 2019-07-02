package com.example.ondemandnepal;

import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

@RequiresApi(api = Build.VERSION_CODES.O)
public class WelcomeActivity extends AppCompatActivity {
    private static final int NOTIFICATION_PERMISSION_CODE = 123;
    private static final int ON_DO_NOT_DISTURB_CALLBACK_CODE = 112;
    public static final String ACCESS_NOTIFICATION_POLICY = null;
    Dialog MyDialog;
    Button btnloguser, btnlogdriver, cross;
    Button btnreguser, btnregdriver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Button register = (Button) findViewById(R.id.welcome_activity_Btnregister);
        Button login = (Button) findViewById(R.id.welcome_activity_Btnlogin);

       requestMutePhonePermsAndMutePhone();
       // requestNotificationPermission();

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




/*    private void requestNotificationPermission() {


        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_NOTIFICATION_POLICY)) {

        }

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_NOTIFICATION_POLICY}, NOTIFICATION_PERMISSION_CODE );
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        //Checking the request code of our request
        if (requestCode == NOTIFICATION_PERMISSION_CODE ) {

            //If permission is granted
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //Displaying a toast
                Toast.makeText(this, "Permission granted now you can read the storage", Toast.LENGTH_LONG).show();
            } else {
                //Displaying another toast if permission is not granted
                Toast.makeText(this, "Oops you just denied the permission", Toast.LENGTH_LONG).show();
            }
        }
    }

*/





    private void requestMutePhonePermsAndMutePhone() {
        try {
            if (Build.VERSION.SDK_INT < 23) {
                AudioManager audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
                audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
            } else if( Build.VERSION.SDK_INT >= 23 ) {
                this.requestDoNotDisturbPermissionOrSetDoNotDisturbApi23AndUp();
            }
        } catch ( SecurityException e ) {

        }
    }

    private void requestDoNotDisturbPermissionOrSetDoNotDisturbApi23AndUp() {
        //TO SUPPRESS API ERROR MESSAGES IN THIS FUNCTION, since Ive no time to figrure our Android SDK suppress stuff
        if( Build.VERSION.SDK_INT < 23 ) {
            return;
        }




        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        if ( notificationManager.isNotificationPolicyAccessGranted()) {
            AudioManager audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
            audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        } else{
            // Ask the user to grant access
            Intent intent = new Intent(android.provider.Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
            // startActivity(intent);
            startActivityForResult( intent, WelcomeActivity.ON_DO_NOT_DISTURB_CALLBACK_CODE );
            //startActivityForResult(intent);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == WelcomeActivity.ON_DO_NOT_DISTURB_CALLBACK_CODE ) {
            this.requestDoNotDisturbPermissionOrSetDoNotDisturbApi23AndUp();
        }
    }






    public void MyCustomAlertDialoglogin() {
        MyDialog = new Dialog(WelcomeActivity.this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.custom_popup_login);
        MyDialog.setTitle("My Custom Dialog");
        btnloguser = (Button) MyDialog.findViewById(R.id.custom_popup_login_Btnuser);
        btnlogdriver = (Button) MyDialog.findViewById(R.id.custom_popup_login_Btndriver);
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
       // requestNotificationPermission();
    }





}
