package fi.softala.jee.demo.d18.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import fi.softala.jee.demo.d18.bean.Osoite;


public class OsoiteRowMapper implements RowMapper<Osoite> {

	public Osoite mapRow(ResultSet rs, int rowNum) throws SQLException {
		Osoite o = new Osoite();
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