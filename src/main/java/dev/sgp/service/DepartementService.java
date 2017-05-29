package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;

@Stateless
public class DepartementService {

	//List<Departement> listeDepartements = new ArrayList<>();
	

	@PersistenceContext(unitName="sgp-pu") private EntityManager em;

	public List<Departement> listerDepartements() {
		return em.createQuery("select d from Departement d", Departement.class).getResultList();
	}

	public void sauvegarderDepartement(Departement depar) {
		//listeDepartements.add(depar);
		em.persist(depar);
	}

}