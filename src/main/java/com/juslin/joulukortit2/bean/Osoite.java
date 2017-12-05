package com.juslin.joulukortit2.bean;

public interface Osoite {
	public abstract int getId();
	public abstract void setId(int id);
	public abstract String getNimi();
	public abstract void setNimi(String nimi);
	public abstract String getKatuosoite();
	public abstract void setKatuosoite(String katuosoite);
	public abstract String getPostinumero();
	public abstract void setPostinumero(String postinumero);
	public abstract String getPostitoimipaikka();
	public abstract void setPostitoimipaikka(String postitoimipaikka);
	public abstract String getOsavaltio();
	public abstract void setOsavaltio(String osavaltio);
	public abstract String getMaa();
	public abstract void setMaa(String maa);
}
