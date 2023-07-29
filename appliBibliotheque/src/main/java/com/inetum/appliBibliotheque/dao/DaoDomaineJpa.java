package com.inetum.appliBibliotheque.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.appliBibliotheque.entity.Domaine;
import com.inetum.appliBibliotheque.entity.Livre;


@Repository 
@Transactional
public class DaoDomaineJpa extends DaoGenericJpa<Domaine, Long> implements DaoDomaine {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	public DaoDomaineJpa() {
		super(Domaine.class);
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	
	
	@Override
	public Domaine findByIdFetchLivres(Long id) {
		return entityManager.createNamedQuery("Domaine.findByIdFetchLivres",Domaine.class) //avec un NamedQuery déclaré dans Employe
				.setParameter(1,id)
				.getSingleResult();
	}
	
}
