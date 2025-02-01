package com.example.siswa.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.siswa.R;

public class HasilUnActivity extends AppCompatActivity {
    TextView tvNISN,tvNama,tvIndo,tvInggris,tvMtk,tvKejuruan;
    Bundle b;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hasil_un);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvNISN = findViewById(R.id.tv_hasil_un_nisn);
        tvNama = findViewById(R.id.tv_hasil_un_nama);
        tvIndo = findViewById(R.id.tv_hasil_un_indo);
        tvInggris = findViewById(R.id.tv_hasil_un_inggris);
        tvMtk = findViewById(R.id.tv_hasil_un_matematika);
        tvKejuruan = findViewById(R.id.tv_hasil_un_kejuruan);

        b = getIntent().getExtras();

        if(b!=null){
            tvNISN.setText(""+b.getInt("nisn"));
            tvNama.setText(b.getString("nama"));
            tvIndo.setText(""+b.getInt("indo"));
            tvInggris.setText(""+b.getInt("inggris"));
            tvMtk.setText(""+b.getInt("matematika"));
            tvKejuruan.setText(""+b.getInt("kejuruan"));
        }
    }
}