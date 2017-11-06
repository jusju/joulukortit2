package com.juslin.joulukortit2.dao;

import java.util.List;

import com.juslin.joulukortit2.bean.*;

public interface HenkiloDAO {

	public abstract void talleta(Henkilo henkilo);

	public abstract Henkilo etsi(int id);

	public abstract List<Henkilo> haeKaikki();

}