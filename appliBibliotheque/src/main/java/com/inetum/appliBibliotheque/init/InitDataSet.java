package com.inetum.appliBibliotheque.init;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.inetum.appliBibliotheque.dao.DaoLivre;
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

	
	@PostConstruct
	public void initData() { // pour que les tables de soient pas vide
  	
    	daoLivreJpa.insert(new Livre(null,"Harry Potter 1" , "JKR"));
    	daoLivreJpa.insert(new Livre(null,"Harry Potter 2" , "JKR"));
    	daoLivreJpa.insert(new Livre(null,"Harry Potter 3" , "JKR"));
    	daoLivreJpa.insert(new Livre(null,"Harry Potter 4" , "JKR"));
    	daoLivreJpa.insert(new Livre(null,"Harry Potter 5" , "JKR"));
    	daoLivreJpa.insert(new Livre(null,"Harry Potter 6" , "JKR"));
    	daoLivreJpa.insert(new Livre(null,"Harry Potter 7" , "JKR"));
    	daoLivreJpa.insert(new Livre(null,"Le Seigneur des Anneaux" , "Tolkien"));
    	daoLivreJpa.insert(new Livre(null,"Les Miserables" , "Victor Hugo"));
    	daoLivreJpa.insert(new Livre(null,"Madame Bovary" , "Gustave Flaubert"));

	}
}
