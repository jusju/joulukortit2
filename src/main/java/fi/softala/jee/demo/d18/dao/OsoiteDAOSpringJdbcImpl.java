package fi.softala.jee.demo.d18.dao;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.juslin.joulukortit2.bean.Osoite;

@Repository
public class OsoiteDAOSpringJdbcImpl {
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void talleta(Osoite osoite) {
		String sql = "INSERT INTO Osoitteet(nimi, katuosoite, postinumero, postitoimipaikka, osavaltio,maa) VALUES(?,?,?,?,?,?)";
		Object[] parametrit = new Object[] { osoite.getNimi(), osoite.getKatuosoite(), osoite.getPostinumero(),
				osoite.getPostitoimipaikka(), osoite.getOsavaltio(), osoite.getMaa() };
		jdbcTemplate.update(sql, parametrit);
	}

	public ArrayList<Osoite> haeKaikki() {
		String sql = "SELECT id, nimi, katuosoite, postinumero, postitoimipaikka, osavaltio, maa FROM "
				+ " Osoitteet ORDER BY nimi";
		RowMapper<Osoite> mapper = new OsoiteRowMapper();
		ArrayList<Osoite> osoitteet = (ArrayList<Osoite>) jdbcTemplate.query(sql, mapper);
		return osoitteet;
	}
	
	public void poista(Integer id) {
		String sql = "DELETE FROM Osoitteet WHERE id=?";
		Object[] parametrit = new Object[] { id };
		jdbcTemplate.update(sql, parametrit);
	}
	
}
