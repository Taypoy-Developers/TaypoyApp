// Proyecto Taypoy
// Fecha: 17/07/2020
// Alumnos:
// Christopher Bryan Avendaño Llanque
// Cardenas Rodriguez Fabrizzio Jorge
// Santos Pamo Bruno Andre
// Juan Ignacio Rodríguez Núñez
package com.example.taypoyapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.firebase.messaging.FirebaseMessaging;

public class MyService_Messaging extends FirebaseMessagingService {
    private static final String TAG="0";
    public MyService_Messaging() {

    }

    public void onMessageReceived(@NonNull RemoteMessage remoteMessage){
        super.onMessageReceived(remoteMessage);
        Log.d(TAG, "FROM: "+ remoteMessage.getFrom());
    }
}
