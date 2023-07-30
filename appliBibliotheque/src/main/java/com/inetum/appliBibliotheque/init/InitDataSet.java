package com.inetum.appliBibliotheque.init;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import com.inetum.appliBibliotheque.dao.DaoAdmin;
import com.inetum.appliBibliotheque.dao.DaoDomaine;
import com.inetum.appliBibliotheque.dao.DaoEmprunt;
import com.inetum.appliBibliotheque.dao.DaoIncident;
import com.inetum.appliBibliotheque.dao.DaoLecteur;
import com.inetum.appliBibliotheque.dao.DaoLivre;
import com.inetum.appliBibliotheque.entity.Administrateur;
import com.inetum.appliBibliotheque.entity.Domaine;
import com.inetum.appliBibliotheque.entity.Emprunt;
import com.inetum.appliBibliotheque.entity.Incident;
import com.inetum.appliBibliotheque.entity.Lecteur;
import com.inetum.appliBibliotheque.entity.Livre;

/**
 * Classe utilitaire qui initalise un jeu de données au démarrage de l'application.
 * @author SRV
 *
 */
@Component

@Profile("init")
public class InitDataSet {
	
	@Autowired
	private DaoLivre daoLivreJpa;
	
	@Autowired
	private DaoLecteur daoLecteurJpa;
	
	@Autowired
	private DaoAdmin daoAdminJpa;
	
	@Autowired
	private DaoEmprunt daoEmpruntJpa;
	
	@Autowired
	private DaoIncident daoIncidentJpa;

	@Autowired
	private DaoDomaine daoDomaineJpa;
	
	@PostConstruct
	public void initData() { // pour que les tables de soient pas vide
		
		
		
		Logger logger = LoggerFactory.getLogger(InitDataSet.class);

    	Livre livre1 = daoLivreJpa.insert(new Livre(null,"Harry Potter 1" , "JKR",true));
    	Livre livre2 = daoLivreJpa.insert(new Livre(null,"Harry Potter 2" , "JKR",true));
    	daoLivreJpa.insert(new Livre(null,"Harry Potter 3" , "JKR",true));
    	daoLivreJpa.insert(new Livre(null,"Harry Potter 4" , "JKR",true));
    	daoLivreJpa.insert(new Livre(null,"Harry Potter 5" , "JKR",true));
    	daoLivreJpa.insert(new Livre(null,"Harry Potter 6" , "JKR",true));
    	daoLivreJpa.insert(new Livre(null,"Harry Potter 7" , "JKR",true));
    	daoLivreJpa.insert(new Livre(null,"Le Seigneur des Anneaux" , "Tolkien",true));
    	daoLivreJpa.insert(new Livre(null,"Les Miserables" , "Victor Hugo",true));
    	daoLivreJpa.insert(new Livre(null,"Madame Bovary" , "Gustave Flaubert",true));
    	daoAdminJpa.insert(new Administrateur(null, "Soulef", "Saoud", "soulefsaoud@biblio.fr", "06XXXXXXXX", "5", "rue de la Biologie",
    			"Paris", "75012", "France", "SoulefS", "Eucaryote"));
		daoAdminJpa.insert(new Administrateur(null,"Victor", "Sicard", "victor.sicard@biblio.fr", "06XXXXXXXX",
				"8", "rue des Mathématiques", "Paris", "75012", "France", "VictorS", "Cauchy-Schwartz"));
		daoAdminJpa.insert(new Administrateur(null, "Roland", "Panzou", "roland.panzou@biblio.fr", "06XXXXXXXX",
				"3", "rue de la Chimie", "Paris", "75012", "France", "RolandP", "Helium"));
		
		
		Lecteur lecteur1 = daoLecteurJpa.insert(new Lecteur("Paul" , "Dirac"));
		Emprunt emprunt1 = daoEmpruntJpa.insert(new Emprunt(livre1,lecteur1));
		
		logger.debug("EMPRUNT : "+ emprunt1.getId().toString());
		

		Domaine domaine1= new Domaine(null,"livre de biologie","sciences");
		
		daoDomaineJpa.insert(domaine1);

		Incident incident1 = new Incident("motif 1");
		incident1.setEmprunt(emprunt1);
		daoIncidentJpa.insert(incident1);
		
		Lecteur lecteur2 = daoLecteurJpa.insert(new Lecteur("Joseph" , "Staline"));
		logger.debug("EMPRUNT : "+ daoLecteurJpa.findById(lecteur2.getId()));
		/*
		Emprunt emprunt2 = new Emprunt(livre2,lecteur2);
		logger.debug("EMPRUNT2 : "+ emprunt2.getId().toString());
		daoEmpruntJpa.insert(emprunt2);
		*/
		
		
		

		
	}
	
	//public void initDataAdmin() {

	//}
}
