package dev.sgp.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;

public class EditerCollaborateurController extends HttpServlet  {
	
	
	@Inject private CollaborateurService collabService;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String matriculeParam = req.getParameter("matricule");
		List<Collaborateur> listeCollaborateurs = collabService.listerCollaborateurs();
		
		
		Collaborateur colabAEditer = null;
		
		
		for (Collaborateur colab : listeCollaborateurs){
			if(colab.getMatricule().equals(matriculeParam))
				colabAEditer = colab;
		}
		

		req.setAttribute("collaborateur", colabAEditer);
		
		
		req.getRequestDispatcher("/WEB-INF/views/collab/editerCollaborateur.jsp")
		.forward(req, resp);

	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nomParam = req.getParameter("nom");
		String prenomParam = req.getParameter("prenom");
		String dateNaissanceParam = req.getParameter("dateNaissance");
		String adresseParam = req.getParameter("adresse");
		String numsecuParam = req.getParameter("numsecu");
		String matriculeParam = req.getParameter("matricule");

		//Collaborateur newCollab = new Collaborateur(nomParam,prenomParam,dateNaissanceParam,adresseParam,numsecuParam);
		//collabService.sauvegarderCollaborateur(newCollab);
		
		collabService.editerCollaborateur(matriculeParam,nomParam,prenomParam,dateNaissanceParam,adresseParam,numsecuParam);
		
		resp.sendRedirect(req.getContextPath() + "/collaborateurs/lister");

	}
}
	