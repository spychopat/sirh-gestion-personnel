package dev.sgp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.util.Constantes;

public class ListerCollaborateursController extends HttpServlet {

	@Override

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws

	ServletException, IOException {

		
		List<Collaborateur> listeCollaborateurs = Constantes.COLLAB_SERVICE.listerCollaborateurs();
		
		/*
		List<String> listeNoms = new ArrayList();
		List<String> listePrenoms = new ArrayList();
		List<String> listeDatesNaissance = new ArrayList();
		List<String> listeAdresses = new ArrayList();
		List<String> listeNumSecu = new ArrayList();
		
		for (Collaborateur collaborateur : listeCollaborateurs) {
			listeNoms.add(collaborateur.getNom());
			listePrenoms.add(collaborateur.getPrenom());
			listeDatesNaissance.add(collaborateur.getDateDeNaissance());
			listeAdresses.add(collaborateur.getAdresse());
			listeNumSecu.add(collaborateur.getNuméroDeSecuSociale());
		}
		
		
		req.setAttribute("listeNoms", listeNoms);
		*/

		req.setAttribute("collaborateurs", listeCollaborateurs);
		req.getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateurs.jsp")

		.forward(req, resp);

	}

}