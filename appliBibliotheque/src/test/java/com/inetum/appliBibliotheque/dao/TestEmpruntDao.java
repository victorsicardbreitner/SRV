package com.inetum.appliBibliotheque.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.inetum.appliBibliotheque.entity.Emprunt;
import com.inetum.appliBibliotheque.entity.Lecteur;
import com.inetum.appliBibliotheque.entity.Livre;

@SpringBootTest
@ActiveProfiles({"oracle"})
public class TestEmpruntDao {

	Logger logger = LoggerFactory.getLogger(TestEmpruntDao.class);
	@Autowired
	private DaoLivre daoLivreJpa;

	@Autowired
	private DaoLecteur daoLecteurJpa;

	@Autowired
	private DaoEmprunt daoEmpruntJpa;

	@Test
	public void testFind() {
		daoLivreJpa.findAll();
	}

	@Test
	public void testEmpruntGetLivre() {

		Livre livre1 = daoLivreJpa.save(new Livre(null, "Harry Potter 1", "JKR", true));
		Lecteur lecteur1 = daoLecteurJpa.save(new Lecteur("Paul", "NomPaul"));

		Emprunt emprunt1 = new Emprunt(livre1, lecteur1);
		emprunt1 = daoEmpruntJpa.save(emprunt1);
		
		//Pas besoin de fetch car cote One.
		Emprunt emprunt1Relu = daoEmpruntJpa.findById(emprunt1.getId()).orElse(emprunt1);

		assertEquals(emprunt1Relu.getLivre().getId(),livre1.getId());

	}

	@Test
	public void testTrivial() {
		assertTrue(true);
	}

}