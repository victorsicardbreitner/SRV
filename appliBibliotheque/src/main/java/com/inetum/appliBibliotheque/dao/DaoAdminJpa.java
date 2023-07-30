package com.inetum.appliBibliotheque.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.appliBibliotheque.entity.Administrateur;

@Repository 
@Transactional
public class DaoAdminJpa extends DaoGenericJpa<Administrateur, Long> implements DaoAdmin {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	

	public DaoAdminJpa() {
		super(Administrateur.class);
	}



}
