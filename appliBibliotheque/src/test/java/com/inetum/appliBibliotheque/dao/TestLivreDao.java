package com.inetum.appliBibliotheque.dao;



import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inetum.appliBibliotheque.dao.DaoLivre;


@SpringBootTest 
//@ActiveProfiles({"oracle"})
public class TestLivreDao {
	

	Logger logger = LoggerFactory.getLogger(TestLivreDao.class);
	@Autowired 
	private DaoLivre daoLivreJpa;
	
	
	
	
	@Test
	public void testFind() {
		daoLivreJpa.findAll();
	}

	
	@Test
	public void testTrivial() {
		assertTrue(true);
	}
	



}
//@ActiveProfiles({"oracle"})