package com.inetum.appliBibliotheque.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.appliBibliotheque.entity.Emprunt;

@Repository 
@Transactional
public class DaoEmpruntJpa extends DaoGenericJpa<Emprunt, Long> implements DaoEmprunt {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	
	
	public DaoEmpruntJpa() {
		super(Emprunt.class);
	}


}
