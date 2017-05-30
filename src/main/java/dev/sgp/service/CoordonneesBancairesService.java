package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.CoordonneesBancaire;
import dev.sgp.entite.Departement;

@Stateless
public class CoordonneesBancairesService {

	@PersistenceContext(unitName="sgp-pu") private EntityManager em;

	public List<CoordonneesBancaire> listerCoordonneesBancaires() {
		return em.createQuery("select d from CoordonneesBancaire d", CoordonneesBancaire.class).getResultList();
	}

	public void sauvegarderCoordonneesBancaire(CoordonneesBancaire coor) {
		//listeDepartements.add(depar);
		em.persist(coor);
	}

	public void editerCoordonneesBancaire(CoordonneesBancaire banque) {
		CoordonneesBancaire banqueAEditer = em.find(CoordonneesBancaire.class, banque.getId());

		if(banqueAEditer==null) return;

		banqueAEditer.setBanque(banque.getBanque());
		banqueAEditer.setBic(banque.getBic());
		banqueAEditer.setIban(banque.getIban());
		em.merge(banqueAEditer);
		
	}

}