package com.inetum.appliBibliotheque.dao;

import java.util.List;

import com.inetum.appliBibliotheque.entity.Lecteur;

public interface DaoLecteur extends DaoGeneric<Lecteur, Long> {
	List<Lecteur> findByNom(String prenom);
}
