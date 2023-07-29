package com.inetum.appliBibliotheque.dao;

import java.util.List;

import com.inetum.appliBibliotheque.entity.Livre;

public interface DaoLivre extends DaoGeneric<Livre, Long>{
	List<Livre> findByTitre(String titre);

	Livre findByIdFetchEmprunts(Long id);
}
