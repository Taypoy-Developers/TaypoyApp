// Proyecto Taypoy
// Fecha: 17/07/2020
// Alumnos:
// Christopher Bryan Avendaño Llanque
// Cardenas Rodriguez Fabrizzio Jorge
// Santos Pamo Bruno Andre
// Juan Ignacio Rodríguez Núñez
package com.example.taypoyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button iniciarsesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarsesion=findViewById(R.id.iniciar_sesion);
        iniciarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Login.class));
            }
        });
    }
}
