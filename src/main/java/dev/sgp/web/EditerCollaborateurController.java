package dev.sgp.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;

public class EditerCollaborateurController extends HttpServlet  {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// récupère la valeur d'un paramètre dont le nom est avecPhoto
		String matriculeParam = req.getParameter("matricule");
		String titreParam = req.getParameter("titre");
		String nomParam = req.getParameter("nom");
		String prenomParam = req.getParameter("prenom");

		resp.setContentType("text/html");

		if(matriculeParam == null || titreParam == null || nomParam == null || prenomParam == null){
			
			String res = "Les paramètres suivants sont incorrects :\r";
			if(matriculeParam == null) res+="matricule\r";
			if(titreParam == null) res+="titre\r";
			if(nomParam == null) res+="nom\r";
			if(prenomParam == null) res+="prenom\r";
			
			resp.sendError(400,res);
		} else {
			// code HTML écrit dans le corps de la réponse
			resp.setStatus(201);
			resp.getWriter().write("Création d’un collaborateur avec les informations suivantes :"
					+ "matricule="+matriculeParam+","
							+ "titre="+titreParam+","
							+ "nom="+nomParam+","
							+ "prenom="+prenomParam);
		}
		
		

	}
}
	