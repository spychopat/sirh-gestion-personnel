package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.sgp.entite.VisiteWeb;

public class VisiteWebService {

	List<VisiteWeb> listeVisites = new ArrayList<VisiteWeb>();

	//@PersistenceContext(unitName="sgp-pu") private EntityManager em;

	public List<VisiteWeb> listerVisitesWeb() {

		//return em.createQuery("select c from VisiteWeb c", VisiteWeb.class).getResultList();
		return listeVisites;
	}

	public void sauvegarderVisiteWeb(VisiteWeb vis) {
		//em.persist(vis);
		listeVisites.add(vis);

	}

}