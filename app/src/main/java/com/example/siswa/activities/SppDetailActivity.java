package com.example.siswa.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.siswa.R;
import com.example.siswa.model.SppResponse;
import com.example.siswa.network.ServiceClient;
import com.example.siswa.network.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SppDetailActivity extends AppCompatActivity {
    TextView tvTahunAjaran;
    TextView tvJuli, tvAgustus, tvSeptember, tvOktober, tvNovember, tvDesember,tvJanuari, tvFebruari, tvMaret, tvApril, tvMei, tvJuni;

    ProgressBar progressBar; // buat progressbar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spp_detail);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        progressBar = findViewById(R.id.progress_spp); // Tambahkan inisialisasi ProgressBar
        tvTahunAjaran = findViewById(R.id.tv_detail_spp_tahun_ajaran);
        tvJuli = findViewById(R.id.tv_ket_spp_juli);
        tvAgustus = findViewById(R.id.tv_ket_spp_agustus);
        tvSeptember = findViewById(R.id.tv_ket_spp_september);
        tvOktober = findViewById(R.id.tv_ket_spp_oktober);
        tvNovember = findViewById(R.id.tv_ket_spp_november);
        tvDesember = findViewById(R.id.tv_ket_spp_desember);
        tvJanuari = findViewById(R.id.tv_ket_spp_januari);
        tvFebruari = findViewById(R.id.tv_ket_spp_februari);
        tvMaret = findViewById(R.id.tv_ket_spp_maret);
        tvApril = findViewById(R.id.tv_ket_spp_april);
        tvMei = findViewById(R.id.tv_ket_spp_mei);
        tvJuni = findViewById(R.id.tv_ket_spp_juni);

       progressBar.setVisibility(View.GONE);// muncul progressbar

        String tingkatan = getSharedPreferences("session", MODE_PRIVATE).getString("tingkatan", "");
        String tahunAjaran = getSharedPreferences("session", MODE_PRIVATE).getString("tahunAjaran", "");
        String kelas = getSharedPreferences("session", MODE_PRIVATE).getString("kelas", "");
        String nis = getSharedPreferences("session", MODE_PRIVATE).getString("nis", "");


        ServiceClient service = ServiceGenerator.createService(ServiceClient.class);
        Call<SppResponse> requestSpp = service.readSpp("loginSiswa", "readSpp", tingkatan, tahunAjaran, kelas, nis);

        requestSpp.enqueue(new Callback<SppResponse>() {
            @Override
            public void onResponse(Call<SppResponse> call, Response<SppResponse> response) {
                progressBar.setVisibility(View.GONE);
                if (!response.body().getHasil().getJuli().isEmpty()){
                    tvTahunAjaran.setText(tahunAjaran);
                    tvJuli.setText(response.body().getHasil().getJuli());
                    tvAgustus.setText(response.body().getHasil().getAgustus());
                    tvSeptember.setText(response.body().getHasil().getSeptember());
                    tvOktober.setText(response.body().getHasil().getOktober());
                    tvNovember.setText(response.body().getHasil().getNovember());
                    tvDesember.setText(response.body().getHasil().getDesember());
                    tvJanuari.setText(response.body().getHasil().getJanuari());
                    tvFebruari.setText(response.body().getHasil().getFebruari());
                    tvMaret.setText(response.body().getHasil().getMaret());
                    tvApril.setText(response.body().getHasil().getApril());
                    tvMei.setText(response.body().getHasil().getMei());
                    tvJuni.setText(response.body().getHasil().getJuni());
                }else {
                    Toast.makeText(SppDetailActivity.this, "Data kosong atau tidak tersedia", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SppResponse> call, Throwable throwable) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(SppDetailActivity.this, "Koneksi error: " + throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
