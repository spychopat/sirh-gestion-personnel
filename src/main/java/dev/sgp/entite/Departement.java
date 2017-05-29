package dev.sgp.entite;

import javax.persistence.Entity;

@Entity
public class Departement {

	@javax.persistence.Id
	Integer id;
	String nom;
	
	
	public Departement() {
	}
	public Departement(Integer id,String nom) {
		this.id = id;
		this.nom = nom;
	}
	
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
