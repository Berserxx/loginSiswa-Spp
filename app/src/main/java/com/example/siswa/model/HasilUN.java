package com.example.siswa.model;

import com.google.gson.annotations.SerializedName;

public class HasilUN{

	@SerializedName("Kejuruan")
	private int kejuruan;

	@SerializedName("NISN")
	private int nISN;

	@SerializedName("Bahasa Inggris")
	private int bahasaInggris;

	@SerializedName("Nama")
	private String nama;

	@SerializedName("Matematika")
	private int matematika;

	@SerializedName("Bahasa Indonesia")
	private int bahasaIndonesia;

	public void setKejuruan(int kejuruan){
		this.kejuruan = kejuruan;
	}

	public int getKejuruan(){
		return kejuruan;
	}

	public void setNISN(int nISN){
		this.nISN = nISN;
	}

	public int getNISN(){
		return nISN;
	}

	public void setBahasaInggris(int bahasaInggris){
		this.bahasaInggris = bahasaInggris;
	}

	public int getBahasaInggris(){
		return bahasaInggris;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setMatematika(int matematika){
		this.matematika = matematika;
	}

	public int getMatematika(){
		return matematika;
	}

	public void setBahasaIndonesia(int bahasaIndonesia){
		this.bahasaIndonesia = bahasaIndonesia;
	}

	public int getBahasaIndonesia(){
		return bahasaIndonesia;
	}

	@Override
 	public String toString(){
		return 
			"HasilUN{" + 
			"kejuruan = '" + kejuruan + '\'' + 
			",nISN = '" + nISN + '\'' + 
			",bahasa Inggris = '" + bahasaInggris + '\'' + 
			",nama = '" + nama + '\'' + 
			",matematika = '" + matematika + '\'' + 
			",bahasa Indonesia = '" + bahasaIndonesia + '\'' + 
			"}";
		}
}