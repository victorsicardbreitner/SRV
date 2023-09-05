package com.inetum.appliBibliotheque.dao;

import com.inetum.appliBibliotheque.entity.Lecteur;

public interface DaoLecteur extends DaoGeneric<Lecteur, Long> {
	Lecteur findById(Long id);
}
