package dev.sgp.ecouteur;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.stream.Stream;
import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.CoordonneesBancaire;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.CoordonneesBancairesService;
import dev.sgp.service.DepartementService;
@WebListener
public class DemarrageEcouteur implements ServletContextListener {
    
    @Inject private CollaborateurService collabService;
    @Inject private DepartementService depService;
    @Inject private CoordonneesBancairesService banqueService;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
    	Collaborateur moi = 
                new Collaborateur("Brengues","Pierre","1993-02-05","22 Marue","123456789012345");
    	
        Stream.of(moi,
                new Collaborateur("Brengues","Mathias","1995-10-19","22 Marue","123456789012345"),
                new Collaborateur("Onyme","Anne","1990-01-01","22 Marue","123456789012345"),
                new Collaborateur("ElBouzati","Abdelmoutaleb","1994-11-02","22 Marue","123456789012345"),
                new Collaborateur("Hochon","Paul","2000-01-01","22 Marue","123456789012345"),
                new Collaborateur("Chirac","Jacques","1932-11-29","Maison des anciens présidents","123456789012345")
                
        ).forEach(collab -> collabService.sauvegarderCollaborateur(collab));
        
        
        Departement testDep = new Departement(1,"TestDep");
        depService.sauvegarderDepartement(testDep);
        CoordonneesBancaire coordsBanque = new CoordonneesBancaire("banque","bic","ban");
        banqueService.sauvegarderCoordonneesBancaire(coordsBanque);
        

    	collabService.editerCollaborateurDepartement(testDep, moi.getMatricule());

    	collabService.editerCollaborateurRib(coordsBanque, moi.getMatricule());
        /*
        Stream.of(
                new Departement(1,"TestDep")
        ).forEach(dep -> depService.sauvegarderDepartement(dep));
        */
        
        /*
        for(Collaborateur collab :  collabService.listerCollaborateurs()){
        	collabService.editerCollaborateurDepartement(testDep, collab.getMatricule());
        	//collab.setDepartement(testDep);
        }
        */
        
        
    }
    
        
    
        
        
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub
        
    }
}