package com.inetum.appliBibliotheque.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.appliBibliotheque.entity.Livre;

@Repository 
@Transactional
public class DaoLivreJpa extends DaoGenericJpa<Livre, Long> implements DaoLivre {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	
	
	public DaoLivreJpa() {
		super(Livre.class);
	}


	@Override
	public List<Livre> findByTitre(String titre) {
		return entityManager.createNamedQuery("Livre.findByTitre",Livre.class)
				.setParameter(1,titre)
				.getResultList();
	}
	
	@Override
	public Livre findByIdFetchEmprunts(Long id) {
		return entityManager.createNamedQuery("Livre.findByIdFetchEmprunts",Livre.class) //avec un NamedQuery déclaré dans Employe
				.setParameter(1,id)
				.getSingleResult();
	}


}
