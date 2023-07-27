package com.inetum.appliBibliotheque.dao;

import java.util.List;

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
	public List<Lecteur> findByNom(String prenom) {
		return entityManager.createNamedQuery("Lecteur.findByNom",Lecteur.class)
				.setParameter(1,prenom)
				.getResultList();
	}

	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	
}
