package dev.sgp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.ActiviteService;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.service.VisiteWebService;
import dev.sgp.util.StatsPage;

public class ActivitesController extends HttpServlet {

	
	//@Inject private CollaborateurService collabService;
	//@Inject private DepartementService departementService;
	@Inject private ActiviteService activitesService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		// List<VisiteWeb> listeVisites = Constantes.VISITE_SERVICE.listerVisitesWeb();
		List<CollabEvt> listeAct = activitesService.listerActivitesCollab();
		
		req.setAttribute("activites", listeAct);
		
		
		req.getRequestDispatcher("/WEB-INF/views/collab/activites.jsp")
		.forward(req, resp);

	}

}