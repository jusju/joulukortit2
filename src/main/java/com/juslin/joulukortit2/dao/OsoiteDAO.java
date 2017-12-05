package com.juslin.joulukortit2.dao;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.juslin.joulukortit2.bean.OsoiteImpl;


public interface OsoiteDAO {

	public abstract void talleta(OsoiteImpl osoite);
	public abstract ArrayList<OsoiteImpl> haeKaikki(); 
	public abstract void poista(Integer id);
	public abstract OsoiteImpl etsi(int id);
	public abstract void paivita(OsoiteImpl osoite);	
}
