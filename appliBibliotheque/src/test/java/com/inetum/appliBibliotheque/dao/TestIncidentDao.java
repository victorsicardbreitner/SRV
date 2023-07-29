package com.inetum.appliBibliotheque.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inetum.appliBibliotheque.entity.Emprunt;
import com.inetum.appliBibliotheque.entity.Incident;
import com.inetum.appliBibliotheque.entity.Lecteur;
import com.inetum.appliBibliotheque.entity.Livre;

@SpringBootTest
//@ActiveProfiles({"oracle"})
public class TestIncidentDao {

	Logger logger = LoggerFactory.getLogger(TestIncidentDao.class);
	@Autowired
	private DaoLivre daoLivreJpa;

	@Autowired
	private DaoLecteur daoLecteurJpa;

	@Autowired
	private DaoEmprunt daoEmpruntJpa;
	
	@Autowired
	private DaoIncident daoIncidentJpa;

	@Test
	public void testFind() {
		daoIncidentJpa.findAll();
	}

	@Test
	public void testIncidentGetEmprunt() {

		Livre livre1 = daoLivreJpa.insert(new Livre(null, "Harry Potter 1", "JKR", true));
		Lecteur lecteur1 = daoLecteurJpa.insert(new Lecteur("Paul", "NomPaul"));
		Incident incident1 = daoIncidentJpa.insert(new Incident("non rendu"));
		
		Emprunt emprunt1 = new Emprunt(livre1, lecteur1);
		emprunt1.setIncident(incident1);
		emprunt1 = daoEmpruntJpa.insert(emprunt1);
		
		//Pas besoin de fetch car OneToOne
		Incident incident1Relu = daoIncidentJpa.findById(incident1.getId());

		assertEquals(incident1Relu.getEmprunt().getId(),emprunt1.getId());
		

		Emprunt emprunt1Relu = daoEmpruntJpa.findById(emprunt1.getId());
		assertEquals(emprunt1Relu.getIncident().getId(),incident1.getId());
		

	}

	@Test
	public void testTrivial() {
		assertTrue(true);
	}

}