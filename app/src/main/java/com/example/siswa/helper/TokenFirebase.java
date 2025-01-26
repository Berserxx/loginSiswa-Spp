package com.example.siswa.helper;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;

public class TokenFirebase extends FirebaseMessagingService {

    private static final String TAG = "TokenFirebase";

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);

        // Log token untuk debugging
        Log.d(TAG, "onNewToken: " + token);

        // Simpan token ke SharedPreferences
        SharedPreferences sp = getSharedPreferences("firebase", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("token", token);
        editor.apply();
    }
}
