package fi.softala.jee.demo.d18.dao;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.juslin.joulukortit2.bean.Osoite;

public interface OsoiteDAO {

	public void talleta(Osoite osoite);
	public ArrayList<Osoite> haeKaikki(); 
	public void poista(Integer id);
	
}
