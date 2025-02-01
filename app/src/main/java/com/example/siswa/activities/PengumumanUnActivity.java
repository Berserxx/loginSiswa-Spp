package com.example.siswa.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.siswa.R;
import com.example.siswa.model.PengumumanUnResponse;
import com.example.siswa.network.ServiceClient;
import com.example.siswa.network.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PengumumanUnActivity extends AppCompatActivity {
    private EditText etNis;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pengumuman_un);

        // Inisialisasi View setelah setContentView
        progressBar = findViewById(R.id.progress_pengumumanUN);
        etNis = findViewById(R.id.et_nis_un);

        // Mengatur insets untuk tampilan yang lebih responsif
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void cekHasil(View view) {
        String nis = etNis.getText().toString().trim();

        // Validasi input NIS
        if (nis.isEmpty()) {
            Toast.makeText(this, "NIS tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        // Membuat request ke API
        ServiceClient service = ServiceGenerator.createService(ServiceClient.class);
        Call<PengumumanUnResponse> requestUN = service.requestHasilUN("un", "readPengumumanUN", nis);

        requestUN.enqueue(new Callback<PengumumanUnResponse>() {
            @Override
            public void onResponse(Call<PengumumanUnResponse> call, Response<PengumumanUnResponse> response) {
                progressBar.setVisibility(View.GONE);

                if (response.body() != null && response.body().getHasilUN() != null) {
                    if ("nis tidak ditemukan".equals(response.body().getHasilUN().getNama())) {
                        Toast.makeText(PengumumanUnActivity.this, "NIS tidak ditemukan", Toast.LENGTH_SHORT).show();
                    } else {
                        // Menyiapkan data untuk dikirim ke Activity hasil
                        Bundle b = new Bundle();
                        b.putInt("nisn", response.body().getHasilUN().getNISN());
                        b.putString("nama", response.body().getHasilUN().getNama());
                        b.putInt("indo", response.body().getHasilUN().getBahasaIndonesia());
                        b.putInt("inggris", response.body().getHasilUN().getBahasaInggris());
                        b.putInt("matematika", response.body().getHasilUN().getMatematika());
                        b.putInt("kejuruan", response.body().getHasilUN().getKejuruan());

                        // Pindah ke Activity HasilUnActivity
                        Intent i = new Intent(PengumumanUnActivity.this, HasilUnActivity.class);
                        i.putExtras(b);
                        startActivity(i);

                        // Reset input NIS setelah berhasil
                        etNis.setText("");
                    }
                } else {
                    Toast.makeText(PengumumanUnActivity.this, "Terjadi kesalahan pada data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PengumumanUnResponse> call, Throwable throwable) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(PengumumanUnActivity.this, "Koneksi error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
