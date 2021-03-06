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

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.service.VisiteWebService;
import dev.sgp.util.StatsPage;

public class StatistiquesController extends HttpServlet {

	
	//@Inject private CollaborateurService collabService;
	//@Inject private DepartementService departementService;
	@Inject private VisiteWebService visiteService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		// List<VisiteWeb> listeVisites = Constantes.VISITE_SERVICE.listerVisitesWeb();
		//List<VisiteWeb> listeVisites = visiteService.listerVisitesWeb();
		
		List<StatsPage> stats = new ArrayList<StatsPage>();
		
		for (VisiteWeb visiteWeb : visiteService.listerVisitesWeb()) {
			boolean trouve = false;
			for (StatsPage stat : stats) {
				if(stat.chemin.equals(visiteWeb.getChemin())){
					stat.addVisite(visiteWeb);
					trouve = true;
				}
			}
			if(!trouve) {
				stats.add(new StatsPage(visiteWeb));
			}
		}
		req.setAttribute("stats", stats);
		
		
		req.getRequestDispatcher("/WEB-INF/views/collab/statistiques.jsp")
		.forward(req, resp);

	}

}