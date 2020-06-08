package com.example.taypoyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        SharedPreferences prefs = getSharedPreferences("login", MODE_PRIVATE);
        final Boolean isloged = prefs.getBoolean("isloged", false);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(2000);

                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                    if (isloged == true) {
                        Intent i = new Intent(SplashScreen.this, CrearLista.class);
                        startActivity(i);
                    } else {
                        Intent i = new Intent(SplashScreen.this, MainActivity.class);
                        startActivity(i);
                    }
                }
            }
            //Intent intent = new Intent(SplashScreen.this, MainActivity.class);
            //startActivity(intent);
            //finish();
        };
        timerThread.start();
    }
}