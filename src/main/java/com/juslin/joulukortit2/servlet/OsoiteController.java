package com.juslin.joulukortit2.servlet;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.juslin.joulukortit2.bean.Henkilo;
import com.juslin.joulukortit2.bean.HenkiloImpl;
import com.juslin.joulukortit2.bean.Osoite;
import com.juslin.joulukortit2.dao.OsoiteDAO;

@Controller
@RequestMapping(value="/osoitteet")
public class OsoiteController {
	
	@Inject
	private OsoiteDAO dao;

	public OsoiteDAO getDao() {
		return dao;
	}

	public void setDao(OsoiteDAO dao) {
		this.dao = dao;
	}
	
	// LISTAAN TARVITTAVAT TIEDOT
	@RequestMapping(value="listaa", method=RequestMethod.GET)
	public String listaaHenkilot(Model model) {
		List<Osoite> osoitteet = dao.haeKaikki();
		
		model.addAttribute("osoitteet", osoitteet);
		return "nakymat/osoitteet";
	}
	
	// LISTAAN TARVITTAVAT TIEDOT
	@RequestMapping(value="kirjaudu", method=RequestMethod.POST)
	public String kirjaudu(@ModelAttribute(value="henkilo") HenkiloImpl henkilo, Model model) {
		List<Osoite> osoitteet = dao.haeKaikki();
		
		model.addAttribute("osoitteet", osoitteet);
		return "nakymat/osoitteet";
	}
}
