package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import dev.sgp.entite.CollabEvt;


@ApplicationScoped
public class ActiviteService {

	
	private List<CollabEvt> listAct = new ArrayList<CollabEvt>();
	
	
	public void recevoirEvenementCollab(@Observes CollabEvt evt){
		listAct.add(evt);
	}
	
	public List<CollabEvt> listerActivitesCollab() {
		return listAct;
	}
}
