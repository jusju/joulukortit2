package com.juslin.joulukortit2.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.juslin.joulukortit2.bean.OsoiteImpl;
import com.juslin.joulukortit2.dao.OsoiteDAO;

@Controller
public class OsoiteRestController {
	@Inject
	OsoiteDAO dao;

	
	@RequestMapping("henkilot.json")
	public @ResponseBody List<OsoiteImpl> haeHenkilotJSON() {
		List<OsoiteImpl> osoitteet = dao.haeKaikki();
		return osoitteet;
	}
	
	@RequestMapping("henkilot")
	public String naytaOSoitelista() {
		return "henk/henkilolista";
	}
}
