package com.inetum.appliBibliotheque.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.appliBibliotheque.entity.Lecteur;

@Repository 
@Transactional
public class DaoLecteurJpa  extends DaoGenericJpa<Lecteur, Long> implements DaoLecteur{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	
	public DaoLecteurJpa() {
		super(Lecteur.class);
	}

	@Override
	public Lecteur findById(Long id) {
		return (Lecteur) entityManager.createNamedQuery("Lecteur.findById",Lecteur.class)
				.setParameter(1,id)
				.getResultList();
	}

	
}
