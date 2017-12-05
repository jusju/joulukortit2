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
import com.juslin.joulukortit2.bean.OsoiteImpl;

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
	
	
	//TYHJÄN FORMIN LUONTI
	@RequestMapping(value="kirjaudu", method=RequestMethod.GET)
	public String tyhjanForminLuonti(Model model) {
		Kayttaja kayttaja = new Kayttaja();
		model.addAttribute("kayttaja", kayttaja);
		System.out.println("KirjautumisController.kirjautumisLogiikka()");
		return "kirjautuminen";
	}
	


	
	//OSOITTEEN TUHOAMINEN
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getView(@PathVariable Integer id, Model model) {
		dao.poista(id);
		List<OsoiteImpl> osoitteet = dao.haeKaikki();
		model.addAttribute("osoitteet", osoitteet);
		return "osoitteet";
	}

	
	//FORMIN TIETOJEN VASTAANOTTO
	@RequestMapping(value="kirjaudu", method=RequestMethod.POST)
	public String kirjautumisPaatos(@ModelAttribute(value="kayttaja") Kayttaja kayttaja, Model model) {
		String kayttajatunnus = kayttaja.getKayttajatunnus();
		String salasana = kayttaja.getSalasana();
		System.out.println("KirjautumisController.kirjautumisPaatos()");
		if(kayttajatunnus.equalsIgnoreCase("pauline") && salasana.equalsIgnoreCase("pauline")) {
			List<OsoiteImpl> osoitteet = dao.haeKaikki();
			model.addAttribute("osoitteet", osoitteet);
			return "osoitteet";
		} else {
			return "virhe";
		}
	}
}
