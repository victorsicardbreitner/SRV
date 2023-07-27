package com.inetum.appliSpringWeb.dao;



import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest 
public class TestCompteDao {
	
	Logger logger = LoggerFactory.getLogger(TestCompteDao.class);


	
	@Test
	public void testTrivial() {
		assertTrue(true);
	}
	



}
//@ActiveProfiles({"oracle"})