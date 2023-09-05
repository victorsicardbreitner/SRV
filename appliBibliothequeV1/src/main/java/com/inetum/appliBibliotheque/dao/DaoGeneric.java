package com.inetum.appliBibliotheque.dao;

import java.util.List;

/**
 * 
 * @author Victor Sicard
 *
 * @param <E> Type d'entité persistante (Client ou Compte)
 * @param <PK> Type de clef primaie (Long ou Integer ou String)
 */
public interface DaoGeneric<E,PK> { //la technologie Spring a une notion de DAO genrik.

	E findById(PK id);
	List<E> findAll();
	E insert(E e);
	void update(E e);
	void deleteById(PK id);
	void deleteAll();
	
}
