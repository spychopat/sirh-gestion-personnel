package dev.sgp.entite;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

import javax.persistence.Entity;

@Entity
public class Collaborateur {
	String matricule;
	String nom;
	String prenom;
	String DateDeNaissance;
	String Adresse;
	String NuméroDeSecuSociale;
	String emailPro;
	String photo;
	ZonedDateTime dateHeureCreation;
	Boolean actif;
	String intitulePoste;
	Departement departement;
	
	
	public Collaborateur(String nom, String prenom, String dateDeNaissance, String adresse,
			String numéroDeSecuSociale) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		DateDeNaissance = dateDeNaissance;
		Adresse = adresse;
		NuméroDeSecuSociale = numéroDeSecuSociale;
		
		this.matricule = UUID.randomUUID().toString();
		
		this.emailPro = prenom+"."+nom+"@masociete.dta";
	}


	public String getNom() {
		return this.nom;
	}


	public String getMatricule() {
		return matricule;
	}


	public String getPrenom() {
		return prenom;
	}


	public String getDateDeNaissance() {
		return DateDeNaissance;
	}


	public String getAdresse() {
		return Adresse;
	}


	public String getNuméroDeSecuSociale() {
		return NuméroDeSecuSociale;
	}


	public String getEmailPro() {
		return emailPro;
	}


	public String getPhoto() {
		return photo;
	}


	public ZonedDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}


	public Boolean getActif() {
		return actif;
	}


	public String getIntitulePoste() {
		return intitulePoste;
	}


	public Departement getDepartement() {
		return departement;
	}
	
	
	
}