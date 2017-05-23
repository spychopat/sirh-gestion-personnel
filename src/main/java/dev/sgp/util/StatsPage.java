package dev.sgp.util;

import dev.sgp.entite.VisiteWeb;

public class StatsPage {

	public String chemin;
	public int totalVisite;
	public int minTemps;
	public int maxTemps;
	public int totalTemps;
	

	


	public StatsPage(VisiteWeb visiteWeb) {
		chemin = visiteWeb.getChemin();
		totalVisite = 1;
		minTemps = visiteWeb.getTempsExecution();
		maxTemps = visiteWeb.getTempsExecution();
		totalTemps = visiteWeb.getTempsExecution();
	}

	public int getMoyenneTemps(){
		return totalTemps/totalVisite;
	}

	public void addVisite(VisiteWeb visiteWeb) {
		
		totalVisite++;
		
		if(minTemps > visiteWeb.getTempsExecution())
			minTemps = visiteWeb.getTempsExecution();
		if(maxTemps < visiteWeb.getTempsExecution())
			maxTemps = visiteWeb.getTempsExecution();
		totalTemps += visiteWeb.getTempsExecution();
	}
	
	
	public String getChemin() {
		return chemin;
	}

	public int getTotalVisite() {
		return totalVisite;
	}

	public int getMinTemps() {
		return minTemps;
	}

	public int getMaxTemps() {
		return maxTemps;
	}

	public int getTotalTemps() {
		return totalTemps;
	}
}
