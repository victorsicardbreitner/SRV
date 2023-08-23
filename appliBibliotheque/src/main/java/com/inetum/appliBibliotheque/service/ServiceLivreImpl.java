package com.inetum.appliBibliotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.appliBibliotheque.dao.DaoLivre;
import com.inetum.appliBibliotheque.dto.LivreDto;
import com.inetum.appliBibliotheque.entity.Emprunt;
import com.inetum.appliBibliotheque.entity.Lecteur;
import com.inetum.appliBibliotheque.entity.Livre;

@Service
@Transactional 
public class ServiceLivreImpl extends AbstractGenericService<Livre,Long,LivreDto> implements ServiceLivre{
	
	@Override
	public CrudRepository<Livre,Long> getDao() {
		return this.daoLivre;
	}
	
	@Override
	public Class<LivreDto> getDtoClass() {
		return LivreDto.class;
	}
	
	@Override
	public Class<Livre> getEClass() {
		return Livre.class;
	}


	@Autowired
	private DaoLivre daoLivre;
	
	@Autowired
	private ServiceEmprunt serviceEmprunt;

	@Override
	public List<Livre> trouverLivreParLecteur(Lecteur lecteur) {
		List<Emprunt> listeEmpruntsLecteur = serviceEmprunt.trouverParLecteur(lecteur);
		return listeEmpruntsLecteur.stream()
						.map(emprunt -> emprunt.getLivre())
						.toList();
	}
	
	
	@Override
	public List<Livre> trouverLivreActuelParLecteur(Lecteur lecteur) {
		List<Emprunt> listeEmpruntsLecteurActuel = serviceEmprunt.trouverParLecteurEtDateFinApresMaintenant(lecteur);
		return listeEmpruntsLecteurActuel.stream()
						.map(emprunt -> emprunt.getLivre())
						.toList();
	}
	
	
	
	
	//
	

}
