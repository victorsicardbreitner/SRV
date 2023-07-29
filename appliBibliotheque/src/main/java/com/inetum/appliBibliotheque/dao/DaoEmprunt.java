package com.inetum.appliBibliotheque.dao;

import com.inetum.appliBibliotheque.entity.Emprunt;
import com.inetum.appliBibliotheque.entity.EmpruntCompositePk;

public interface DaoEmprunt extends DaoGeneric<Emprunt, EmpruntCompositePk>{

}
//List<Emprunt> findByTitre(String titre);