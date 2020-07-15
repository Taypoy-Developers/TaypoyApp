package com.example.taypoyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CrearLista extends AppCompatActivity {
    private EditText editTextInput;
    public static String[] CARNES ={
            "Pollo",
            "Carne de Res",
            "Pescado",
            "Carne de Cerdo"
    };
    public static String[] FRUTAS ={
            "Manzana",
            "Naranja",
            "Mandarina",
            "Platano",
            "Pera",
            "Papaya",
            "Mango",
            "Fresa"
    };
    public static String[] VERDURAS ={
            "Cebolla",
            "Papa",
            "Zanahoria",
            "Lechuga",
            "Apio",
            "Tomate",
            "Espinaca"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_lista);
        SharedPreferences prefs = getSharedPreferences("login", MODE_PRIVATE);
        String username = prefs.getString("username", String.valueOf(findViewById(R.id.box_nic)));

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(username);

        LinearLayout seccion_carnes = (LinearLayout) findViewById(R.id.seccion_carnes);

        for (String carne : CARNES) {
            CheckBox opcion1 = new CheckBox(this);
            opcion1.setText(carne);
            opcion1.setLayoutParams(
                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            seccion_carnes.addView(opcion1);
        }

        LinearLayout seccion_frutas = (LinearLayout) findViewById(R.id.seccion_frutas);

        for (String fruta : FRUTAS) {
            CheckBox opcion2 = new CheckBox(this);
            opcion2.setText(fruta);
            opcion2.setLayoutParams(
                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            seccion_frutas.addView(opcion2);
        }

        LinearLayout seccion_verduras = (LinearLayout) findViewById(R.id.seccion_verduras);

        for (String verdura : VERDURAS) {
            CheckBox opcion3 = new CheckBox(this);
            opcion3.setText(verdura);
            opcion3.setLayoutParams(
                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            seccion_verduras.addView(opcion3);
        }


    }

}