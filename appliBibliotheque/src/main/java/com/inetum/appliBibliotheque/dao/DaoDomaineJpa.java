package com.inetum.appliBibliotheque.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.appliBibliotheque.entity.Domaine;


@Repository 
@Transactional
public class DaoDomaineJpa extends DaoGenericJpa<Domaine, Long> implements DaoDomaine {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	public DaoDomaineJpa() {
		super(Domaine.class);
	}

	@Override
	public Domaine findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}
	
}
