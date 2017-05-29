package dev.sgp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.entite.TypeCollabEvt;

@Stateless
public class CollaborateurService {


	@Inject Event<CollabEvt> collabEvt;

	//List<Collaborateur> listeCollaborateurs = new ArrayList<>();
	@PersistenceContext(unitName="sgp-pu") private EntityManager em;




	public Collaborateur listerCollaborateursAvecMatricule(String matricule) {
		return em.createQuery("select c from Collaborateur c where c.matricule = "+matricule, Collaborateur.class).getSingleResult();
	}

	public List<Collaborateur> listerCollaborateurs() {
		return em.createQuery("select c from Collaborateur c", Collaborateur.class).getResultList();
	}


	public List<Collaborateur> listerCollaborateursAvecDepartementId(Integer departement_id) {
		return em.createQuery("select c from Collaborateur c where c.departement.id = "+departement_id, Collaborateur.class).getResultList();
	}


	public void sauvegarderCollaborateur(Collaborateur collab) {

		CollabEvt nouveauCollabEvt = new CollabEvt(TypeCollabEvt.CREATION_COLLAB,collab.getMatricule());
		collabEvt.fire(nouveauCollabEvt);


		em.persist(collab);
		//listeCollaborateurs.add(collab);

	}

	public void editerCollaborateur(Integer matriculeParam, String nomParam, String prenomParam, String dateNaissanceParam, String adresseParam, String numsecuParam) {


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
	
	public void editerCollaborateurLimite(Integer matriculeParam,String dateNaissanceParam, String adresseParam) {


		//Collaborateur colabAEditer = em.createQuery("select c from Collaborateur c where c.matricule = :mat", Collaborateur.class).setParameter("mat", matriculeParam).getSingleResult();
		Collaborateur colabAEditer = em.find(Collaborateur.class, matriculeParam);

		if(colabAEditer==null) return;

		colabAEditer.setDateDeNaissance(dateNaissanceParam);
		colabAEditer.setAdresse(adresseParam);

		em.merge(colabAEditer);

		CollabEvt nouveauCollabEvt = new CollabEvt(TypeCollabEvt.MODIFICATION_COLLAB,matriculeParam);
		collabEvt.fire(nouveauCollabEvt);


	}

	public void editerCollaborateurDepartement(Departement dep,Integer matriculeParam) {


		Collaborateur colabAEditer = em.find(Collaborateur.class, matriculeParam);

		if(colabAEditer==null) return;

		colabAEditer.setDepartement(dep);

		em.merge(colabAEditer);

		CollabEvt nouveauCollabEvt = new CollabEvt(TypeCollabEvt.MODIFICATION_COLLAB_DEPARTEMENT,matriculeParam);
		collabEvt.fire(nouveauCollabEvt);


	}


}