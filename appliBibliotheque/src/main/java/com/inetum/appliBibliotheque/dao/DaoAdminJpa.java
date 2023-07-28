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
	
<<<<<<< HEAD
=======
	public DaoAdminJpa() {
		super(Administrateur.class);
	}

	@Override
	public List<Administrateur> findByNom(String prenom) {
		return entityManager.createNamedQuery("Administrateur.findByNom",Administrateur.class)
				.setParameter(1,prenom)
				.getResultList();
	}

>>>>>>> soulef
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	
	public DaoAdminJpa() {
		super(Administrateur.class);
	}

	@Override
	public Administrateur findById(Long id) {
		return (Administrateur) entityManager.createNamedQuery("Admin.findById",Administrateur.class)
				.setParameter(1,id)
				.getResultList();
	}



}
