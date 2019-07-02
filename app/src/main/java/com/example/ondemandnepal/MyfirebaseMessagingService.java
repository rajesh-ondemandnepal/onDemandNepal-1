package com.example.ondemandnepal;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class
MyfirebaseMessagingService extends FirebaseMessagingService {

    int id,userId;
    String deviceInfo,token;
    public MyfirebaseMessagingService() {
    }

   /*

   @Override
    public void onMessageReceived(RemoteMessage message) {
        RemoteMessage remoteMessage =null;
        super.onMessageReceived(remoteMessage);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, "channel_id")
                .setContentTitle(remoteMessage.getNotification().getTitle())
                .setContentText(remoteMessage.getNotification().getBody())
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setStyle(new NotificationCompat.BigTextStyle())
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0, notificationBuilder.build());
    }

    */


    private Context getContext() {
        return null;
    }

    public void showNotification (String from, String notification, Intent intent) {
        Context context =getContext();
        int Notification_ID =1;
        PendingIntent pendingIntent = PendingIntent.getActivity(
                context,
                Notification_ID,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );


        String NOTIFICATION_CHANNEL_ID = "channel_id";
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "My Notifications", NotificationManager.IMPORTANCE_DEFAULT);

            // Configure the notification channel.
            notificationChannel.setDescription("Channel description");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID);
        Notification mNotification = builder
                .setContentTitle(from)
                .setContentText(notification)

//                .setTicker("Hearty365")
//                .setContentInfo("Info")
                //     .setPriority(Notification.PRIORITY_MAX)

                .setContentIntent(pendingIntent)

                .setAutoCancel(true)
//                .setDefaults(Notification.DEFAULT_ALL)
//                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                .build();

        notificationManager.notify(/*notification id*/Notification_ID, mNotification);

    }


    @Override
    public void onNewToken(String token) {
        Log.d(TAG, "Refreshed token: " + token);
        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.

        //this.token=token;
        sendRegistrationToServer(token);
       // sendToServer(token);
    }


   /* private void sendToServer(String token) {

        try {
            URL url = new URL("http://192.168.1.69:8080/fcm");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true);
            connection.setDoInput(true);

            connection.setRequestMethod("POST");

            DataOutputStream dos = new DataOutputStream(connection.getOutputStream());

            dos.writeBytes("token=" + token);

            connection.connect();

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // Do whatever you want after the
                // token is successfully stored on the server
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/

    private void sendRegistrationToServer(String token) {


        OnDemandNepalApi onDemandNepalApi = NetworkServices.getInstance().getClient();

        //  int id=this.id ;
      //  int userId=this.userId;
//        String pushToken=this.token ;
        String pushToken=token ;
        // token =fcQwtisiMYQ:APA91bECKnmmpd-XpPzGskUprWLT8eCmMR5OFit2-vq4SZGRzoMrcGOVl3FLtZlR5vlUjnTDFYZYLhU48197E9cxmM4BvMGJ7Ofv0W_Z0YeLEHHS_S2n3VM3dH78j1YH-EkY8xooiuoJ
       // String deviceInfo =this.deviceInfo;


        Call<TokenResponse> tokenRegister = onDemandNepalApi.tokenRegister(new TokenRequest ( id, userId, pushToken,null));


        tokenRegister.enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                //success
                response.body();

            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                //failure
                t.printStackTrace();

            }
        });
    }
}



