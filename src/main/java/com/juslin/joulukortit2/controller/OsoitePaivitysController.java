package com.juslin.joulukortit2.controller;

import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.juslin.joulukortit2.bean.Osoite;
import com.juslin.joulukortit2.dao.OsoiteDAO;

@Controller
@RequestMapping (value="/kasky")
public class OsoitePaivitysController {
	@Inject
	private OsoiteDAO dao;
	
	public OsoiteDAO getDao() {
		return dao;
	}

	public void setDao(OsoiteDAO dao) {
		this.dao = dao;
	}
	// UUDEN OSOITTEEN LISÄYS
	@RequestMapping(value="lisaa", method=RequestMethod.GET)
	public String lisaaOsoite(Model model) {
		Osoite osoite = new Osoite();
		osoite.setId(1);
		model.addAttribute("osoite", osoite);
		System.out.println("OsoiteController.lisaaOsoite()");
		return "lisaa_osoite";
	}
	
	
	//OSOITTEEN PAIVITTAMINEN
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String muokkaaOsoitetta(@PathVariable Integer id, Model model) {
		Osoite osoite = dao.etsi(id);
		model.addAttribute("osoite", osoite);
		return "lisaa_osoite";
	}
	
	@RequestMapping(value="osoitelisays", method=RequestMethod.POST)
	public String osoiteLisays(@ModelAttribute(value="osoite") Osoite osoite, Model model) {
		System.out.println("OsoitePaivitysController.osoiteLisays()");
		Map<String, Object> arvot = model.asMap();
		if(osoite != null) {
			if((osoite.getId()) != 1) {
				dao.paivita(osoite);
			} else {
				dao.talleta(osoite);					
			}
		}

		List<Osoite> osoitteet = dao.haeKaikki();
		model.addAttribute("osoitteet", osoitteet);
		return "osoitteet";
	}
}
