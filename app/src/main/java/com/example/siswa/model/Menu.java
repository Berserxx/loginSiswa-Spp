package com.example.siswa.model;

public class Menu {
    private int gambarMenu;
    private String namaMenu;

    public Menu(int gambarMenu,String namaMenu) {
        this.gambarMenu = gambarMenu;
        this.namaMenu = namaMenu;
    }

    public int getGambarMenu() {
        return gambarMenu;
    }

    public String getNamaMenu() {return namaMenu; }
}
