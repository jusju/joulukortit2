package com.juslin.joulukortit2.dao;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.juslin.joulukortit2.bean.Osoite;


public interface OsoiteDAO {

	public abstract void talleta(Osoite osoite);
	public abstract ArrayList<Osoite> haeKaikki(); 
	public abstract void poista(Integer id);
	public abstract Osoite etsi(int id);
	public abstract void paivita(Osoite osoite);	
}
