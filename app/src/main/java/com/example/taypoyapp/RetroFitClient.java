package com.example.taypoyapp;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetroFitClient {
    private static Retrofit instance;

    public static Retrofit GetInstance(){
        if(instance==null){
            instance= new Retrofit.Builder().baseUrl("http://suggestqueries.google.com/").addConverterFactory(ScalarsConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        }
        return instance;
    }
}
