package com.juslin.joulukortit2.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.juslin.joulukortit2.bean.Kayttaja;
import com.juslin.joulukortit2.bean.Osoite;

import com.juslin.joulukortit2.dao.OsoiteDAO;

@Controller
@RequestMapping (value="/toiminto")
public class OsoiteController {
	
	@Inject
	private OsoiteDAO dao;
	
	public OsoiteDAO getDao() {
		return dao;
	}

	public void setDao(OsoiteDAO dao) {
		this.dao = dao;
	}
	
	
	//TYHJ�N FORMIN LUONTI
	@RequestMapping(value="kirjaudu", method=RequestMethod.GET)
	public String tyhjanForminLuonti(Model model) {
		Kayttaja kayttaja = new Kayttaja();
		model.addAttribute("kayttaja", kayttaja);
		System.out.println("KirjautumisController.kirjautumisLogiikka()");
		return "kirjautuminen";
	}
	

	@RequestMapping(value="lisaaosoite", method=RequestMethod.POST)
	public String lisaaOsoite(@ModelAttribute(value="osoite") Osoite osoite, Model model) {
		if(dao.etsi(osoite.getId()) != null) {
			dao.talleta(osoite);	
		} else {
			dao.paivita(osoite);
		}
		
		List<Osoite> osoitteet = dao.haeKaikki();
		model.addAttribute("osoitteet", osoitteet);
		return "osoitteet";
	}
	
	// UUDEN OSOITTEEN LIS�YS
	@RequestMapping(value="lisaa", method=RequestMethod.GET)
	public String lisaaOsoite(Model model) {
		Osoite osoite = new Osoite();
		model.addAttribute("osoite", osoite);
		System.out.println("OsoiteController.lisaaOsoite()");
		return "lisaa_osoite";
	}
	
	//OSOITTEEN TUHOAMINEN
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getView(@PathVariable Integer id, Model model) {
		dao.poista(id);
		List<Osoite> osoitteet = dao.haeKaikki();
		model.addAttribute("osoitteet", osoitteet);
		return "osoitteet";
	}
	//OSOITTEEN PAIVITTAMINEN
	@RequestMapping(value="/muokkaa/{id}", method=RequestMethod.GET)
	public String muokkaaOsoitetta(@PathVariable Integer id, Model model) {
		Osoite osoite = dao.etsi(id);
		model.addAttribute("osoite", osoite);
		return "lisaa_osoite";
	}
	
	//FORMIN TIETOJEN VASTAANOTTO
	@RequestMapping(value="kirjaudu", method=RequestMethod.POST)
	public String kirjautumisPaatos(@ModelAttribute(value="kayttaja") Kayttaja kayttaja, Model model) {
		String kayttajatunnus = kayttaja.getKayttajatunnus();
		String salasana = kayttaja.getSalasana();
		System.out.println("KirjautumisController.kirjautumisPaatos()");
		if(kayttajatunnus.equalsIgnoreCase("pauline") && salasana.equalsIgnoreCase("pauline")) {
			List<Osoite> osoitteet = dao.haeKaikki();
			model.addAttribute("osoitteet", osoitteet);
			return "osoitteet";
		} else {
			return "virhe";
		}
	}
}
