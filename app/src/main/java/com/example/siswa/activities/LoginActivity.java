package com.example.siswa.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.siswa.R;
import com.example.siswa.model.LoginResponse;
import com.example.siswa.network.ServiceClient;
import com.example.siswa.network.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText etNis, etPass;
    Spinner spTingkatan, spTahunAjaran;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        etNis = findViewById(R.id.et_nis_siswa);
        etPass = findViewById(R.id.et_pass_siswa);
        spTingkatan = findViewById(R.id.sp_tingkatan);
        spTahunAjaran = findViewById(R.id.sp_tahun_ajaran);
        progressBar = findViewById(R.id.progress_login);

        Button btnLogin = findViewById(R.id.btn_login_siswa);
        btnLogin.setOnClickListener(this::Login);

        boolean cekLogin = getSharedPreferences("session",MODE_PRIVATE).getBoolean("login",false);

        if(cekLogin){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }

    }

    public void Login(View view) {
        // Tampilkan ProgressBar
        progressBar.setVisibility(View.VISIBLE);

        // Validasi input
        if (etNis.getText().toString().isEmpty()) {
            progressBar.setVisibility(View.GONE); // Sembunyikan ProgressBar
            Toast.makeText(this, "Nis tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }

        if (etPass.getText().toString().isEmpty()) {
            progressBar.setVisibility(View.GONE); // Sembunyikan ProgressBar
            Toast.makeText(this, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }

        String nis = etNis.getText().toString().trim();
        String pass = etPass.getText().toString().trim();
        String tingkatan = spTingkatan.getSelectedItem().toString();
        String tahunAjaran = spTahunAjaran.getSelectedItem().toString();

        ServiceClient service = ServiceGenerator.createService(ServiceClient.class);
        Call<LoginResponse> requestLogin = service.loginSiswa("loginSiswa","login",tingkatan,tahunAjaran,nis,pass);
        requestLogin.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (!response.body().getHasil().equals("error")){
                    progressBar.setVisibility(View.GONE);
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    SharedPreferences sp = getSharedPreferences("session",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("login",true);
                    editor.putString("nis",nis);
                    editor.putString("tingkatan",tingkatan);
                    editor.putString("tahunAjaran",tahunAjaran);
                    editor.putString("kelas",response.body().getHasil());
                    editor.commit();
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this,"login gagal",Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable throwable) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(LoginActivity.this,"koneksi eror",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
