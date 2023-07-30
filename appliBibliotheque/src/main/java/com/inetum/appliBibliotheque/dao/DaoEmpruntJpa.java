package com.inetum.appliBibliotheque.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private DaoLivre daoLivreJpa;
	
	@Autowired
	private DaoLecteur daoLecteurJpa;
	
	
	public DaoEmpruntJpa() {
		super(Emprunt.class);
	}
	
	/**
	 * pour rendre les entités encore persistantes avec les @MapsId dans Emprunt
	 */
	@Override
	public Emprunt insert(Emprunt e) {
		e.setLivre(daoLivreJpa.findById(e.getLivre().getId())); 
		e.setLecteur(daoLecteurJpa.findById(e.getLecteur().getId()));
		//getEntityManager().merge
		getEntityManager().persist(e);
		return e;
	}
}
