package com.inetum.appliBibliotheque.dao;

import com.inetum.appliBibliotheque.entity.Domaine;


public interface DaoDomaine extends DaoGeneric<Domaine, Long>{
	Domaine findById(Long id);
}
