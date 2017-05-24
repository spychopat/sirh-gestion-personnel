package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;

@ApplicationScoped
public class DepartementService {

	List<Departement> listeDepartements = new ArrayList<>();

	public List<Departement> listerDepartements() {

		return listeDepartements;

	}

	public void sauvegarderDepartement(Departement depar) {

		listeDepartements.add(depar);

	}

}