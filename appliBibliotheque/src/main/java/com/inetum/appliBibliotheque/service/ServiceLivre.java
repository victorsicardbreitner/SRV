package com.inetum.appliBibliotheque.service;

import java.util.List;

import com.inetum.appliBibliotheque.dto.LivreDto;
import com.inetum.appliBibliotheque.entity.Lecteur;
import com.inetum.appliBibliotheque.entity.Livre;

public interface ServiceLivre extends GenericService<Livre,Long,LivreDto>{
	
	List<Livre> trouverLivreParLecteur(Lecteur lecteur);

	List<Livre> trouverLivreActuelParLecteur(Lecteur lecteur);

}
