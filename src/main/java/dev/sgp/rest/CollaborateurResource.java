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
import dev.sgp.service.CollaborateurService;

@Path("/collaborateurs")
public class CollaborateurResource {

	@Inject private CollaborateurService collabService;

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
		return collabService.listerCollaborateursAvecMatricule(matricule);
	}

	@PUT
	@Path("/{matricule}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response  updateColla(Collaborateur collab) {      
		collabService.editerCollaborateurLimite(collab.getMatricule(), collab.getDateDeNaissance(), collab.getAdresse());
		ResponseBuilder builder = Response.ok("texte");
		builder.language("fr").header("Content-type", "text/html");
		return builder.build();
	}

}

