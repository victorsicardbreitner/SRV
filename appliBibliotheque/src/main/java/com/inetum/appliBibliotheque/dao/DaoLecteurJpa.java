package com.inetum.appliBibliotheque.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.inetum.appliBibliotheque.entity.Lecteur;

public class DaoLecteurJpa  extends DaoGenericJpa<Lecteur, Long> implements DaoLecteur{

	@PersistenceContext
	private EntityManager entityManager;
	
	public DaoLecteurJpa(Class<Lecteur> entityClass) {
		super(Lecteur.class);
	}

	@Override
	public Lecteur findById(Long id) {
		return (Lecteur) entityManager.createNamedQuery("Lecteur.findById",Lecteur.class)
				.setParameter(1,id)
				.getResultList();
	}

	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	
}
