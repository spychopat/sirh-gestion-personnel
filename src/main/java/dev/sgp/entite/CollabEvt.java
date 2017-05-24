package dev.sgp.entite;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class CollabEvt {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private ZonedDateTime dateHeure;
	private TypeCollabEvt type;
	private String matricule;
	

	public CollabEvt(){
		
	}


	public CollabEvt(TypeCollabEvt type, String matricule) {
		super();
		this.dateHeure = ZonedDateTime.now();
		this.type = type;
		this.matricule = matricule;
	}
	
	
	
	
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setDateHeure(ZonedDateTime dateHeure) {
		this.dateHeure = dateHeure;
	}


	public void setType(TypeCollabEvt type) {
		this.type = type;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}


	public ZonedDateTime getDateHeure() {
		return dateHeure;
	}


	public TypeCollabEvt getType() {
		return type;
	}

	public String getMatricule() {
		return matricule;
	}
	
}
