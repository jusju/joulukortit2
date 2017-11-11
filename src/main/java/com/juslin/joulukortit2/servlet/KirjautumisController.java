package com.juslin.joulukortit2.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.juslin.joulukortit2.bean.HenkiloImpl;
import com.juslin.joulukortit2.bean.Kayttaja;

@Controller
@RequestMapping (value="/toiminto")
public class KirjautumisController {
	
	//FORMIN TIETOJEN VASTAANOTTO
	@RequestMapping(value="kirjaudu", method=RequestMethod.GET)
	public String naytaKirjautuminen(Model model) {
		Kayttaja kayttaja = new Kayttaja();
		model.addAttribute("kayttaja", kayttaja);
		System.out.println("KirjautumisController.kirjautumisLogiikka()");
		return "kirjautuminen";
	}
	
	//FORMIN TIETOJEN VASTAANOTTO
	@RequestMapping(value="kirjaudu", method=RequestMethod.POST)
	public String kirjautumisPaatos(@ModelAttribute(value="kayttaja") Kayttaja kayttaja) {
		String kayttajatunnus = kayttaja.getKayttajatunnus();
		String salasana = kayttaja.getSalasana();
		System.out.println("KirjautumisController.kirjautumisPaatos()");
		if(kayttajatunnus.equalsIgnoreCase("pauline") && salasana.equalsIgnoreCase("pauline")) {
			return "kirjautuminen";
		} else {
			return "virhe";
		}
	}
}
