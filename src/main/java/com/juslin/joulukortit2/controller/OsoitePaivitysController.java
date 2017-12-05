package com.juslin.joulukortit2.controller;

import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.juslin.joulukortit2.bean.OsoiteImpl;
import com.juslin.joulukortit2.dao.OsoiteDAO;
import org.springframework.validation.BindingResult;


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
		OsoiteImpl osoite = new OsoiteImpl();
		osoite.setId(-1);
		model.addAttribute("osoite", osoite);
		System.out.println("OsoiteController.lisaaOsoite()");
		return "lisaa_osoite";
	}
	
	
	//OSOITTEEN PAIVITTAMINEN
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String muokkaaOsoitetta(@PathVariable Integer id, Model model) {
		OsoiteImpl osoite = dao.etsi(id);
		model.addAttribute("osoite", osoite);
		return "lisaa_osoite";
	}
	
	@RequestMapping(value="osoitelisays", method=RequestMethod.POST)
	public String osoiteLisays(@ModelAttribute(value="osoite") @Valid OsoiteImpl osoite, Model model, BindingResult result) {
		System.out.println("OsoitePaivitysController.osoiteLisays()");
		List<OsoiteImpl> osoitteet = dao.haeKaikki();
		model.addAttribute("osoitteet", osoitteet);
		
		if (result.hasErrors()) {
			return "../nakymat/lisaa_osoite";
		} 
		
		if(osoite != null) {
			if((osoite.getId()) != -1) {
				dao.paivita(osoite);
			} else {
				dao.talleta(osoite);					
			}
		}
		return "../nakymat/osoitteet";
	}
}
