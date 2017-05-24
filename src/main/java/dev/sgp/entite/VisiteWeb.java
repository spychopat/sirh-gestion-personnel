package dev.sgp.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class VisiteWeb {
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	String chemin;
	Integer tempsExecution;
	
	
	public VisiteWeb(String chemin, Integer tempsExecution) {
		super();
		this.chemin = chemin;
		this.tempsExecution = tempsExecution;
	}

	public VisiteWeb() {
		super();
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

	public void setId(Integer id) {
		this.id = id;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public void setTempsExecution(Integer tempsExecution) {
		this.tempsExecution = tempsExecution;
	}
	
	
	
	
}
