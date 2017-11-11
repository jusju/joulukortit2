package com.juslin.joulukortit2.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.juslin.joulukortit2.bean.HenkiloImpl;
import com.juslin.joulukortit2.bean.Kayttaja;
import com.juslin.joulukortit2.bean.Osoite;
import com.juslin.joulukortit2.dao.HenkiloDAO;
import com.juslin.joulukortit2.bean.Henkilo;
import com.juslin.joulukortit2.bean.HenkiloImpl;
import com.juslin.joulukortit2.dao.OsoiteDAO;

@Controller
@RequestMapping (value="/toiminto")
public class KirjautumisController {
	
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
	
	//OSOITTEEN TUHOAMINEN
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getView(@PathVariable Integer id, Model model) {
		//Henkilo henkilo = dao.etsi(id);
		//model.addAttribute("henkilo", henkilo);
		
		return "henk/view";
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
