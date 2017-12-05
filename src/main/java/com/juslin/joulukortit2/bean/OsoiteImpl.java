package com.juslin.joulukortit2.bean;

import javax.validation.constraints.Size;

public class OsoiteImpl implements Osoite{
	
	private int id;
	
	@Size(min = 1, max = 255)
	private String nimi;
	
	private String katuosoite;
	
	private String postinumero;
	
	private String postitoimipaikka;
	
	private String osavaltio;
	
	private String maa;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public String getKatuosoite() {
		return katuosoite;
	}
	public void setKatuosoite(String katuosoite) {
		this.katuosoite = katuosoite;
	}
	public String getPostinumero() {
		return postinumero;
	}
	public void setPostinumero(String postinumero) {
		this.postinumero = postinumero;
	}
	public String getPostitoimipaikka() {
		return postitoimipaikka;
	}
	public void setPostitoimipaikka(String postitoimipaikka) {
		this.postitoimipaikka = postitoimipaikka;
	}
	public String getOsavaltio() {
		return osavaltio;
	}
	public void setOsavaltio(String osavaltio) {
		this.osavaltio = osavaltio;
	}
	public String getMaa() {
		return maa;
	}
	public void setMaa(String maa) {
		this.maa = maa;
	}
}
