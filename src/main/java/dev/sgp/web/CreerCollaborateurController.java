package dev.sgp.web;

import java.io.IOException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;

public class CreerCollaborateurController extends HttpServlet {
	
	
	@Inject private CollaborateurService collabService;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws

	ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/collab/creerCollaborateur.jsp")

		.forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws

	ServletException, IOException {

		String nomParam = req.getParameter("nom");
		String prenomParam = req.getParameter("prenom");
		String dateNaissanceParam = req.getParameter("dateNaissance");
		String adresseParam = req.getParameter("adresse");
		String numsecuParam = req.getParameter("numsecu");

		Collaborateur newCollab = new Collaborateur(nomParam,prenomParam,dateNaissanceParam,adresseParam,numsecuParam);
		collabService.sauvegarderCollaborateur(newCollab);
		
		
		resp.sendRedirect(req.getContextPath() + "/collaborateurs/lister");

	}
}
