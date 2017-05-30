package dev.sgp.rest;


import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.CoordonneesBancaire;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.CoordonneesBancairesService;

@Path("/collaborateurs")
public class CollaborateurResource {

	@Inject private CollaborateurService collabService;
	@Inject private CoordonneesBancairesService coordBancaireService;

	/*
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Collaborateur> list() {
		return collabService.listerCollaborateurs();
	}
	 */

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Collaborateur> lock(@QueryParam("departement") Integer departement_id) {

		//System.out.println("departement_id = "+departement_id);
		if(departement_id != null)
			return collabService.listerCollaborateursAvecDepartementId(departement_id);
		else
			return collabService.listerCollaborateurs();
	}



	@GET
	@Path("/{matricule}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Collaborateur getCollabMatricule(@PathParam("matricule") String matricule) {
		//System.out.println("MATRICULE : "+matricule);
		return collabService.trouverCollaborateurParMatricule(matricule);
	}

	@PUT
	@Path("/{matricule}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response  updateColla(@PathParam("matricule") String matricule,Collaborateur collab) { 
		//System.out.println("\n\nMATRICULE : "+matricule);
		collabService.editerCollaborateurLimite(Integer.parseInt(matricule), collab.getDateDeNaissance(), collab.getAdresse());
		ResponseBuilder builder = Response.ok("Collaborateur modifié avec succès.");
		builder.language("fr").header("Content-type", "text/html");
		return builder.build();
	}

	
	@GET
	@Path("/{matricule}/banque") 
	@Produces(MediaType.APPLICATION_JSON)
	public CoordonneesBancaire getCollabMatriculeBanque(@PathParam("matricule") String matricule) {
		//System.out.println("MATRICULE : "+matricule);
		return collabService.trouverCollaborateurParMatricule(matricule).getRib();
	}
	
	@PUT
	@Path("/{matricule}/banque")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response  updateCollabMatriculeBanque(@PathParam("matricule") String matricule,CoordonneesBancaire banque) {
		coordBancaireService.editerCoordonneesBancaire(banque);
		ResponseBuilder builder = Response.ok("Coordonnees bancaire modifiées avec succès.");
		builder.language("fr").header("Content-type", "text/html");
		return builder.build();
	}
	
}

