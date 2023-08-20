package com.inetum.appliBibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.appliBibliotheque.dao.DaoEmprunt;
import com.inetum.appliBibliotheque.dto.EmpruntDto;
import com.inetum.appliBibliotheque.entity.Emprunt;
import com.inetum.appliBibliotheque.entity.EmpruntCompositePk;

@Service
@Transactional 
public class ServiceEmpruntImpl extends AbstractGenericService<Emprunt,EmpruntCompositePk,EmpruntDto> implements ServiceEmprunt {

	@Override
	public CrudRepository<Emprunt,EmpruntCompositePk> getDao() {
		return this.daoEmprunt;
	}
	
	@Override
	public Class<EmpruntDto> getDtoClass() {
		return EmpruntDto.class;
	}
	
	@Override
	public Class<Emprunt> getEClass() {
		return Emprunt.class;
	}


	@Autowired
	private DaoEmprunt daoEmprunt;

}
