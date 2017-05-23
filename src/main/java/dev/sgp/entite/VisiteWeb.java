package dev.sgp.entite;

import javax.persistence.Entity;

@Entity
public class VisiteWeb {
	Integer id;
	String chemin;
	Integer tempsExecution;
	
	public VisiteWeb(String chemin, Integer tempsExecution) {
		super();
		this.chemin = chemin;
		this.tempsExecution = tempsExecution;
	}

	public Integer getId() {
		return id;
	}

	public String getChemin() {
		return chemin;
	}

	public Integer getTempsExecution() {
		return tempsExecution;
	}
	
	
}
