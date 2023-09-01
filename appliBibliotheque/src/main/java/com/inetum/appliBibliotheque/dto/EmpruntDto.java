package com.inetum.appliBibliotheque.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class EmpruntDto {

	private String nomLecteur;
	private String nomLivre;
	private String dateDebut; //mettre en format date ?
	private String dateFin;
	private String incident;
	
	public EmpruntDto(String nomLecteur, String nomLivre, String dateDebut, String dateFin, String incident) {
		this.nomLecteur = nomLecteur;
		this.nomLivre = nomLivre;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.incident=incident;
	}
	
	public EmpruntDto(String nomLecteur, String nomLivre, String dateDebut, String dateFin) {
		this(nomLecteur,nomLivre,dateDebut,dateFin,"");
	}
	
	
	public void setNomLecteur(String setNomLecteur) {
		this.nomLecteur = setNomLecteur.toUpperCase();
	}
	




	
}
