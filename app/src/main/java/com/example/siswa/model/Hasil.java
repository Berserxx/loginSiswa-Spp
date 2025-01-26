package com.example.siswa.model;

import com.google.gson.annotations.SerializedName;

public class Hasil{

	@SerializedName("maret")
	private String maret;

	@SerializedName("mei")
	private String mei;

	@SerializedName("november")
	private String november;

	@SerializedName("september")
	private String september;

	@SerializedName("januari")
	private String januari;

	@SerializedName("februari")
	private String februari;

	@SerializedName("juni")
	private String juni;

	@SerializedName("agustus")
	private String agustus;

	@SerializedName("oktober")
	private String oktober;

	@SerializedName("juli")
	private String juli;

	@SerializedName("april")
	private String april;

	@SerializedName("desember")
	private String desember;

	public void setMaret(String maret){
		this.maret = maret;
	}

	public String getMaret(){
		return maret;
	}

	public void setMei(String mei){
		this.mei = mei;
	}

	public String getMei(){
		return mei;
	}

	public void setNovember(String november){
		this.november = november;
	}

	public String getNovember(){
		return november;
	}

	public void setSeptember(String september){
		this.september = september;
	}

	public String getSeptember(){
		return september;
	}

	public void setJanuari(String januari){
		this.januari = januari;
	}

	public String getJanuari(){
		return januari;
	}

	public void setFebruari(String februari){
		this.februari = februari;
	}

	public String getFebruari(){
		return februari;
	}

	public void setJuni(String juni){
		this.juni = juni;
	}

	public String getJuni(){
		return juni;
	}

	public void setAgustus(String agustus){
		this.agustus = agustus;
	}

	public String getAgustus(){
		return agustus;
	}

	public void setOktober(String oktober){
		this.oktober = oktober;
	}

	public String getOktober(){
		return oktober;
	}

	public void setJuli(String juli){
		this.juli = juli;
	}

	public String getJuli(){
		return juli;
	}

	public void setApril(String april){
		this.april = april;
	}

	public String getApril(){
		return april;
	}

	public void setDesember(String desember){
		this.desember = desember;
	}

	public String getDesember(){
		return desember;
	}

	@Override
 	public String toString(){
		return 
			"Hasil{" +
			"maret = '" + maret + '\'' + 
			",mei = '" + mei + '\'' + 
			",november = '" + november + '\'' + 
			",september = '" + september + '\'' + 
			",januari = '" + januari + '\'' + 
			",februari = '" + februari + '\'' + 
			",juni = '" + juni + '\'' + 
			",agustus = '" + agustus + '\'' + 
			",oktober = '" + oktober + '\'' + 
			",juli = '" + juli + '\'' + 
			",april = '" + april + '\'' + 
			",desember = '" + desember + '\'' + 
			"}";
		}
}