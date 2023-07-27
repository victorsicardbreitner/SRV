package com.inetum.appliBibliotheque.dao;

import java.util.List;

import com.inetum.appliBibliotheque.entity.Administrateur;

public interface DaoAdmin extends DaoGeneric<Administrateur, Long> {
	List<Administrateur> findByNom(String prenom);
	
}
