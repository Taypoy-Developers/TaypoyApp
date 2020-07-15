package com.example.taypoyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;



public class Login extends AppCompatActivity {
    Button btn_go_register;
    EditText email,password,username;
    FirebaseAuth fAuth;
    Button btn_iniciar_sesion;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.box_correo);
        password=findViewById(R.id.box_contrasena);
        username=findViewById(R.id.box_nic);
        btn_iniciar_sesion=findViewById(R.id.btn_iniciar_sesion);
        fAuth=FirebaseAuth.getInstance();
        btn_go_register=findViewById(R.id.btn_go_register);
        btn_go_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });
        btn_iniciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correo=email.getText().toString();
                String contrasena=password.getText().toString();
                final String nicname=username.getText().toString();
                if(correo.equals("")){
                    Toast.makeText(Login.this, "Ingrese un correo", Toast.LENGTH_SHORT).show();
                }
                else if(contrasena.equals("")){
                    Toast.makeText(Login.this, "Ingrese una contraseña", Toast.LENGTH_SHORT).show();
                } else{
                    fAuth.signInWithEmailAndPassword(correo,contrasena).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                //preferencias
                                SharedPreferences prefs = getSharedPreferences("login", MODE_PRIVATE);
                                SharedPreferences.Editor editor = prefs.edit();
                                editor.putString("username", nicname);
                                editor.putBoolean("isLoged", true);
                                editor.apply();
                                //preferencias
                                Toast.makeText(Login.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                                startActivity (new Intent(Login.this, Intento_SearchBar.class));
                            }
                            else {
                                Toast.makeText(Login.this, "Usuario o contraseña incorrectos "+ task.getException().getMessage(), Toast.LENGTH_SHORT ).show();
                            }
                        }
                    });
                }



            }
        });


    }

}
