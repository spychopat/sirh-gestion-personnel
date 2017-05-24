package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.entite.VisiteWeb;

@ApplicationScoped
public class VisiteWebService {

	List<VisiteWeb> listeVisites = new ArrayList<>();

	public List<VisiteWeb> listerVisitesWeb() {

		return listeVisites;

	}

	public void sauvegarderVisiteWeb(VisiteWeb vis) {

		listeVisites.add(vis);

	}

}