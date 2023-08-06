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
public class TestLivreDao {

	Logger logger = LoggerFactory.getLogger(TestLivreDao.class);
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
	public void testLivreEtEmpruntFetchEtLazy() {

		Livre livre1 = daoLivreJpa.save(new Livre(null, "Harry Potter 1", "JKR", true));
		Lecteur lecteur1 = daoLecteurJpa.save(new Lecteur("Paul", "NomPaul"));
		Lecteur lecteur2 = daoLecteurJpa.save(new Lecteur("Jean", "NomJean"));

		Emprunt emprunt1 = new Emprunt(livre1, lecteur1);
		emprunt1 = daoEmpruntJpa.save(emprunt1);
		
		Emprunt emprunt2 = new Emprunt(livre1, lecteur2);
		emprunt2 = daoEmpruntJpa.save(emprunt2);

		Livre livre1FetchEmprunts = daoLivreJpa.findByIdFetchEmprunts(livre1.getId());

		Livre livre1ReluSansFetch = daoLivreJpa.findById(livre1.getId()).orElse(null);

		assertEquals(livre1FetchEmprunts.getEmprunts().size(),2);
		
		
		for (Emprunt empr : livre1FetchEmprunts.getEmprunts()) {
			assertEquals(empr.getLivre().getId(),livre1.getId());
		}
		
		
		// on ne peut pas aller chercher le get car le lien @---ToMany est LAZY
		boolean testNecessiteFetch=false;
		try {
			assertEquals(livre1ReluSansFetch.getEmprunts().size(),2);
		} catch (Exception e) {
			testNecessiteFetch=true;
			assertTrue(e instanceof org.hibernate.LazyInitializationException);
		}
		assertTrue(testNecessiteFetch);
		

	}

	@Test
	public void testTrivial() {
		assertTrue(true);
	}

}