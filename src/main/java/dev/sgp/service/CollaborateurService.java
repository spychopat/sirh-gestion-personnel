package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.TypeCollabEvt;

@Stateless
public class CollaborateurService {

	
	@Inject Event<CollabEvt> collabEvt;
	
	//List<Collaborateur> listeCollaborateurs = new ArrayList<>();
	@PersistenceContext(unitName="sgp-pu") private EntityManager em;
	
	
	public List<Collaborateur> listerCollaborateurs() {
		
		return em.createQuery("select c from Collaborateur c", Collaborateur.class).getResultList();

	}
	
	public void sauvegarderCollaborateur(Collaborateur collab) {
		
		CollabEvt nouveauCollabEvt = new CollabEvt(TypeCollabEvt.CREATION_COLLAB,collab.getMatricule());
		collabEvt.fire(nouveauCollabEvt);
		
		
		em.persist(collab);
		//listeCollaborateurs.add(collab);

	}
	
	public void editerCollaborateur(String matriculeParam, String nomParam, String prenomParam,
			String dateNaissanceParam, String adresseParam, String numsecuParam) {
		
		
		
		
		//Collaborateur colabAEditer = em.createQuery("select c from Collaborateur c where c.matricule = :mat", Collaborateur.class).setParameter("mat", matriculeParam).getSingleResult();
		Collaborateur colabAEditer = em.find(Collaborateur.class, matriculeParam);

		if(colabAEditer==null) return;
		
		colabAEditer.setNom(nomParam);
		colabAEditer.setPrenom(prenomParam);
		colabAEditer.setDateDeNaissance(dateNaissanceParam);
		colabAEditer.setAdresse(adresseParam);
		colabAEditer.setNuméroDeSecuSociale(numsecuParam);
		colabAEditer.setEmailPro(prenomParam+"."+nomParam+"@masociete.dta"); 
		
		em.merge(colabAEditer);

		CollabEvt nouveauCollabEvt = new CollabEvt(TypeCollabEvt.MODIFICATION_COLLAB,matriculeParam);
		collabEvt.fire(nouveauCollabEvt);
		
		
	}

}