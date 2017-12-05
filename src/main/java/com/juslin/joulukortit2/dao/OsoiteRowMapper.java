package com.juslin.joulukortit2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.juslin.joulukortit2.bean.OsoiteImpl;


public class OsoiteRowMapper implements RowMapper<OsoiteImpl> {

	public OsoiteImpl mapRow(ResultSet rs, int rowNum) throws SQLException {
		OsoiteImpl o = new OsoiteImpl();
		o.setId(rs.getInt("id"));
		o.setNimi(rs.getString("nimi"));
		o.setKatuosoite(rs.getString("katuosoite"));
		o.setPostinumero(rs.getString("postinumero"));
		o.setPostitoimipaikka(rs.getString("postitoimipaikka"));
		o.setOsavaltio(rs.getString("osavaltio"));
		o.setMaa(rs.getString("maa"));
		return o;
	}
}