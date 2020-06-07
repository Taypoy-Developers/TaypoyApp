package com.example.taypoyapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.multidex.MultiDexApplication;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText etnombre,ettelefono,etcorreo_elec,etcontraseña,etcontraseña_confirmar;
    Button btn_go_login;
    Button  btn_registrar_usuario;
    FirebaseAuth fAuth;
    String userID;
    FirebaseFirestore fStore;
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
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        btn_registrar_usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String correo,contraseña, contra_confirma, nombre, telefono;
                correo=etcorreo_elec.getText().toString();
                contraseña=etcontraseña.getText().toString();
                contra_confirma=etcontraseña_confirmar.getText().toString();
                nombre= etnombre.getText().toString();
                telefono=ettelefono.getText().toString();
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
                fAuth.createUserWithEmailAndPassword(correo,contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            // send verification link

                            FirebaseUser fuser = fAuth.getCurrentUser();
                            fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(Register.this, "Verification Email Has been Sent.", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFailure: Email not sent " + e.getMessage());
                                }
                            });

                            Toast.makeText(Register.this, "User Created.", Toast.LENGTH_SHORT).show();
                            userID = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fStore.collection("users").document(userID);
                            Map<String,Object> user = new HashMap<>();
                            user.put("fName",nombre);
                            user.put("email",correo);
                            user.put("phone",telefono);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG, "onSuccess: user Profile is created for "+ userID);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFailure: " + e.toString());
                                }
                            });
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        }else {
                            Toast.makeText(Register.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}