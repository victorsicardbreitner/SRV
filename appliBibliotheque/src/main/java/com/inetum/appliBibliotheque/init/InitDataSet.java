package com.inetum.appliBibliotheque.init;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.inetum.appliBibliotheque.dao.DaoAdmin;
import com.inetum.appliBibliotheque.dao.DaoEmprunt;
import com.inetum.appliBibliotheque.dao.DaoLecteur;
import com.inetum.appliBibliotheque.dao.DaoLivre;
import com.inetum.appliBibliotheque.entity.Administrateur;
import com.inetum.appliBibliotheque.entity.Emprunt;
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

	
	@PostConstruct
	public void initData() { // pour que les tables de soient pas vide
  	
    	Livre livre1 = new Livre(null,"Harry Potter 1" , "JKR");
    	daoLivreJpa.insert(livre1);
    	daoLivreJpa.insert(new Livre(null,"Harry Potter 2" , "JKR"));
    	daoLivreJpa.insert(new Livre(null,"Harry Potter 3" , "JKR"));
    	daoLivreJpa.insert(new Livre(null,"Harry Potter 4" , "JKR"));
    	daoLivreJpa.insert(new Livre(null,"Harry Potter 5" , "JKR"));
    	daoLivreJpa.insert(new Livre(null,"Harry Potter 6" , "JKR"));
    	daoLivreJpa.insert(new Livre(null,"Harry Potter 7" , "JKR"));
    	daoLivreJpa.insert(new Livre(null,"Le Seigneur des Anneaux" , "Tolkien"));
    	daoLivreJpa.insert(new Livre(null,"Les Miserables" , "Victor Hugo"));
    	daoLivreJpa.insert(new Livre(null,"Madame Bovary" , "Gustave Flaubert"));
    	daoAdminJpa.insert(new Administrateur(null, "Soulef", "Saoud", "soulefsaoud@biblio.fr", "06XXXXXXXX", "5", "rue de la Biologie",
    			"Paris", "75012", "France", "SoulefS", "Eucaryote"));
		daoAdminJpa.insert(new Administrateur(null,"Victor", "Sicard", "victor.sicard@biblio.fr", "06XXXXXXXX",
				"8", "rue des Mathématiques", "Paris", "75012", "France", "VictorS", "Cauchy-Schwartz"));
		daoAdminJpa.insert(new Administrateur(null, "Roland", "Panzou", "roland.panzou@biblio.fr", "06XXXXXXXX",
				"3", "rue de la Chimie", "Paris", "75012", "France", "RolandP", "Helium"));
		
		
		Lecteur lecteur1 = new Lecteur("Paul" , "NomPaul");
		daoLecteurJpa.insert(lecteur1);
		Emprunt emprunt1 = new Emprunt(livre1,lecteur1);
		Logger logger = LoggerFactory.getLogger(InitDataSet.class);
		logger.debug("EMPRUNT : "+ emprunt1.getId().toString());
		daoEmpruntJpa.insert(emprunt1);
		
	}
	
	//public void initDataAdmin() {

	//}
}
