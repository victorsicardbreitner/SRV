package com.inetum.appliBibliotheque.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.appliBibliotheque.entity.Emprunt;
import com.inetum.appliBibliotheque.entity.EmpruntCompositePk;

@Repository 
@Transactional
public class DaoEmpruntJpa extends DaoGenericJpa<Emprunt, EmpruntCompositePk> implements DaoEmprunt {

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
