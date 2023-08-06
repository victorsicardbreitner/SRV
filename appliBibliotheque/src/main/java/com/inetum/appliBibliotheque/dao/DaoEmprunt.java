package com.inetum.appliBibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inetum.appliBibliotheque.entity.Emprunt;
import com.inetum.appliBibliotheque.entity.EmpruntCompositePk;

public interface DaoEmprunt extends JpaRepository<Emprunt, EmpruntCompositePk>{

}
//List<Emprunt> findByTitre(String titre);