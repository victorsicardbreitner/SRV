package com.inetum.appliBibliotheque.dao;

import java.util.List;

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
	
	public DaoAdminJpa() {
		super(Administrateur.class);
	}

	@Override
	public List<Administrateur> findByNom(String nom) {
		return entityManager.createNamedQuery("Administrateur.findByNom",Administrateur.class)
				.setParameter(1,nom)
				.getResultList();
	}

	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

}
