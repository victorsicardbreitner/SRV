package com.inetum.appliSpringWeb.dao;



import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inetum.appliBibliotheque.dao.DaoLivre;

@SpringBootTest //Classe de collaboration entre SpringBoot et JUnit (Gestion de BeforeEach etc.)
//@ActiveProfiles({"oracle"})
public class TestCompteDao {
	
	Logger logger = LoggerFactory.getLogger(TestCompteDao.class);

	@Autowired 
	private DaoLivre daoLivreJpa;

	
	@Test
	public void testTrivial() {
		assertTrue(true);
	}
	



}
