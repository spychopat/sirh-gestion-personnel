package dev.sgp.entite;

import javax.persistence.Entity;

@Entity
public class Departement {
	Integer id;
	String nom;
	

	@javax.persistence.Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
}
