package dev.sgp.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import dev.sgp.entite.VisiteWeb;

public class VisiteWebService {
 
	@PersistenceContext(unitName="sgp-pu") 
	private EntityManager em;
	
	@Resource
    private UserTransaction userTransaction;

	public List<VisiteWeb> listerVisitesWeb() {

		return em.createQuery("select c from VisiteWeb c", VisiteWeb.class).getResultList();
	}

	public void sauvegarderVisiteWeb(VisiteWeb vis) {
		 try {
			userTransaction.begin();
			em.persist(vis);
			userTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}