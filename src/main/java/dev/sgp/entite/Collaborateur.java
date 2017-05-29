package dev.sgp.entite;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

@Entity
public class Collaborateur {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer matricule;
	String nom;
	String prenom;
	String DateDeNaissance;
	String Adresse;
	String NuméroDeSecuSociale;
	String emailPro;
	String photo;
	String dateHeureCreation;
	Boolean actif;
	String intitulePoste;
	
	@ManyToOne
	Departement departement;
	
	
	public Collaborateur(){
	}
	
	public Collaborateur(String nom, String prenom, String dateDeNaissance, String adresse, String numéroDeSecuSociale) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		DateDeNaissance = dateDeNaissance;
		Adresse = adresse;
		NuméroDeSecuSociale = numéroDeSecuSociale;
		
		//this.matricule = UUID.randomUUID().toString();
		this.emailPro = prenom+"."+nom+"@masociete.dta";
		this.dateHeureCreation = ZonedDateTime.now().toString();
		
	}

	public String getNom() {
		return this.nom;
	}

	public Integer getMatricule() {
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

	public String getDateHeureCreation() {
		return dateHeureCreation;
	}

	public Boolean getActif() {
		return actif;
	}

	public String getIntitulePoste() {
		return intitulePoste;
	}
	
	@ManyToOne
	public Departement getDepartement() {
		return departement;
	}


	public void setMatricule(Integer matricule) {
		this.matricule = matricule;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public void setDateDeNaissance(String dateDeNaissance) {
		DateDeNaissance = dateDeNaissance;
	}


	public void setAdresse(String adresse) {
		Adresse = adresse;
	}


	public void setNuméroDeSecuSociale(String numéroDeSecuSociale) {
		NuméroDeSecuSociale = numéroDeSecuSociale;
	}


	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public void setDateHeureCreation(String dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}


	public void setActif(Boolean actif) {
		this.actif = actif;
	}


	public void setIntitulePoste(String intitulePoste) {
		this.intitulePoste = intitulePoste;
	}


	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
	
	
}