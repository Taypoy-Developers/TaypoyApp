package com.example.taypoyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText etnombre,ettelefono,etcorreo_elec,etcontraseña,etcontraseña_confirmar;
    Button btn_go_login;
    Button  btn_registrar_usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btn_go_login=findViewById(R.id.btn_go_login);
        btn_go_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this, Login.class));
            }
        });
        etnombre=findViewById(R.id.box_nombre_reg);
        ettelefono=findViewById(R.id.box_telefono_reg);
        etcorreo_elec=findViewById(R.id.box_correo_reg);
        etcontraseña=findViewById(R.id.box_contrasena_reg);
        etcontraseña_confirmar=findViewById(R.id.box_contrasena_reg_confir);
        btn_registrar_usuario=findViewById(R.id.btn_registrar_usuario);
        btn_registrar_usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correo,contraseña, contra_confirma;
                correo=etcorreo_elec.getText().toString();
                contraseña=etcontraseña.getText().toString();
                contra_confirma=etcontraseña_confirmar.getText().toString();
                if(correo.equals("")){
                    Toast.makeText(Register.this, "Ingrese un correo", Toast.LENGTH_SHORT).show();
                }
                else if(contraseña.equals("")){
                    Toast.makeText(Register.this, "Ingrese una contraseña", Toast.LENGTH_SHORT).show();
                }
                else if(!contraseña.equals(contra_confirma)){
                    Toast.makeText(Register.this, "Ingrese la contraseña en ambas casillas correctamente", Toast.LENGTH_SHORT).show();
                }
                else {
                    //Autentica registro
                    Toast.makeText(Register.this, "Usuario registrado", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}