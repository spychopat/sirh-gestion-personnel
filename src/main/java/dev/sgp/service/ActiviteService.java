package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Collaborateur;


public class ActiviteService {

	
	//private List<CollabEvt> listAct = new ArrayList<CollabEvt>();

	@PersistenceContext(unitName="sgp-pu") private EntityManager em;
	
	
	public void recevoirEvenementCollab(@Observes CollabEvt evt){
		//listAct.add(evt);
		em.persist(evt);
	}
	
	public List<CollabEvt> listerActivitesCollab() {
		return em.createQuery("select c from CollabEvt c", CollabEvt.class).getResultList();
	}
}
