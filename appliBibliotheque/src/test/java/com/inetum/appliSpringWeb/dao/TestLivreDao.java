package com.inetum.appliSpringWeb.dao;



import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

<<<<<<< HEAD:appliBibliotheque/src/test/java/com/inetum/appliSpringWeb/dao/TestCompteDao.java
@SpringBootTest 
public class TestCompteDao {
=======
import com.inetum.appliBibliotheque.dao.DaoLivre;

@SpringBootTest //Classe de collaboration entre SpringBoot et JUnit (Gestion de BeforeEach etc.)
//@ActiveProfiles({"oracle"})
public class TestLivreDao {
	
}
	Logger logger = LoggerFactory.getLogger(TestLivreDao.class);


	
	@Test
	public void testTrivial() {
		assertTrue(true);
	}
	



}
//@ActiveProfiles({"oracle"})