package com.example.siswa.model;

import com.google.gson.annotations.SerializedName;

public class PengumumanUnResponse{

	@SerializedName("hasilUN")
	private HasilUN hasilUN;

	public void setHasilUN(HasilUN hasilUN){
		this.hasilUN = hasilUN;
	}

	public HasilUN getHasilUN(){
		return hasilUN;
	}

	@Override
 	public String toString(){
		return 
			"PengumumanUnResponse{" + 
			"hasilUN = '" + hasilUN + '\'' + 
			"}";
		}
}