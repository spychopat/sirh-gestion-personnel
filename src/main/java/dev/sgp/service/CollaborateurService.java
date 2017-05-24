package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.TypeCollabEvt;

@ApplicationScoped
public class CollaborateurService {

	
	@Inject Event<CollabEvt> collabEvt;
	
	List<Collaborateur> listeCollaborateurs = new ArrayList<>();
	

	public List<Collaborateur> listerCollaborateurs() {

		return listeCollaborateurs;

	}

	public void sauvegarderCollaborateur(Collaborateur collab) {
		
		CollabEvt nouveauCollabEvt = new CollabEvt(TypeCollabEvt.CREATION_COLLAB,collab.getMatricule());
		collabEvt.fire(nouveauCollabEvt);
		
		listeCollaborateurs.add(collab);

	}

	public void editerCollaborateur(String matriculeParam, String nomParam, String prenomParam,
			String dateNaissanceParam, String adresseParam, String numsecuParam) {
		
		
		Collaborateur colabAEditer = null;
		for (Collaborateur colab : listeCollaborateurs){
			if(colab.getMatricule().equals(matriculeParam))
				colabAEditer = colab;
		}
		
		if(colabAEditer==null) return;
		
		colabAEditer.setNom(nomParam);
		colabAEditer.setPrenom(prenomParam);
		colabAEditer.setDateDeNaissance(dateNaissanceParam);
		colabAEditer.setAdresse(adresseParam);
		colabAEditer.setNuméroDeSecuSociale(numsecuParam);
		colabAEditer.setEmailPro(prenomParam+"."+nomParam+"@masociete.dta"); // Oui, c'est sale
		
	}

}