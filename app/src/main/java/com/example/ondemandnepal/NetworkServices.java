package com.example.ondemandnepal;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkServices {
    private final static String API_BASE_URL = "http://192.168.1.113:8080/";
    private OnDemandNepalApi client;

    private static NetworkServices instance;

    private NetworkServices() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder().addInterceptor(interceptor);

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );

        Retrofit retrofit =
                builder
                        .client(
                                httpClient.build()
                        )
                        .build();

        client = retrofit.create(OnDemandNepalApi.class);
    }

    public static NetworkServices getInstance() {
        if (instance == null) {
            instance = new NetworkServices();
        }
        return instance;
    }

    public OnDemandNepalApi getClient() {
        return client;
    }
}
