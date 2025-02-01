package com.example.siswa.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.siswa.R;
import com.example.siswa.activities.PengumumanUnActivity;
import com.example.siswa.activities.SppDetailActivity;
import com.example.siswa.model.Menu;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
    private Context context;
    private List<Menu> listMenu;

    public MenuAdapter(Context context, List<Menu> listMenu) {
        this.context = context;
        this.listMenu = listMenu;
    }

    @NonNull
    @Override
    public MenuAdapter.MenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_menu, viewGroup, false);
        return new MenuViewHolder(view);
    }
    public class MenuViewHolder extends RecyclerView.ViewHolder {
        ImageView ivGambarMenu;
        TextView tvNamaMenu;
        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            ivGambarMenu = itemView.findViewById(R.id.iv_item_menu);
            tvNamaMenu = itemView.findViewById(R.id.tv_item_menu);
        }

        public void bindItem(Menu menu){
            ivGambarMenu.setImageResource(menu.getGambarMenu());
            tvNamaMenu.setText(menu.getNamaMenu());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (menu.getNamaMenu()){
                        case "SPP":
                            context.startActivity(new Intent(context, SppDetailActivity.class));
                            break;
                        case "Pengumuman UN":
                            context.startActivity(new Intent(context, PengumumanUnActivity.class));
                            break;
                    }
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.MenuViewHolder holder, int position) {
        holder.bindItem(listMenu.get(position));
    }

    @Override
    public int getItemCount() {
        return listMenu.size();
    }

}
