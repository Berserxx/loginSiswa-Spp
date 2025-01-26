package com.example.siswa.activities;

import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.siswa.R;
import com.example.siswa.adapter.MenuAdapter;
import com.example.siswa.model.Menu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvMenu;

    int[]gambarMenu = {R.drawable.spp};
    String[]namaMenu = {"SPP"};
    List<Menu>listMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rvMenu = findViewById(R.id.rv_menu);

        GridLayoutManager glm = new GridLayoutManager(this,2);
        rvMenu.setLayoutManager(glm);

        listMenu = new ArrayList<>();

        for (int i = 0; i < gambarMenu.length; i++) {
            Menu menu = new Menu(gambarMenu[i],namaMenu[i]);
            listMenu.add(menu);
        }
        MenuAdapter adapter = new MenuAdapter(MainActivity.this,listMenu);
        rvMenu.setAdapter(adapter);
    }
}