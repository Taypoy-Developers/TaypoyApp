package com.example.taypoyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class CrearLista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_lista);

        SharedPreferences prefs = getSharedPreferences("login", MODE_PRIVATE);
        String username = prefs.getString("username", String.valueOf(findViewById(R.id.box_nic)));

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(username);
    }
}