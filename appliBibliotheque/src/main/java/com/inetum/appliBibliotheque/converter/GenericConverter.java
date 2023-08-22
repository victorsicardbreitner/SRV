package com.inetum.appliBibliotheque.converter;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.inetum.appliBibliotheque.dto.EmpruntDto;
import com.inetum.appliBibliotheque.entity.Emprunt;

public class GenericConverter {

	//genericConverter.map(compteEntity,CompteDto.class)
	public static <S,D> D map(S source , Class<D> targetClass) {
		D target = null;
		try {
			target = targetClass.getDeclaredConstructor().newInstance(); //on crée une nouvelle instance de la classe voulue en retour
			if(source instanceof Emprunt) { //specificte de conversion Dto
				Emprunt sourceEmp = (Emprunt) source; //pour pouvoir utiliser les methodes get
				EmpruntDto empDto = new EmpruntDto(
						sourceEmp.getLecteur().getPrenom(),
						sourceEmp.getLivre().getTitre(),
						sourceEmp.getDate_debut().toString(),
						sourceEmp.getDate_fin().toString()
						);
				if(sourceEmp.getIncident() != null) empDto.setIncident(sourceEmp.getIncident().getMotif());
				else empDto.setIncident("aucun incident");
				BeanUtils.copyProperties(empDto, target);
			}
			else {
				BeanUtils.copyProperties(source, target);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return target;
	}
	
	//GenericConverter.map(ListeCompteEntity,CompteDto.class)
	public static <S,D> List<D> map(List<S> sourceList, Class<D> targetClass){
		return sourceList.stream()
				.map((source) -> map(source,targetClass))
				.toList();
	}

}
