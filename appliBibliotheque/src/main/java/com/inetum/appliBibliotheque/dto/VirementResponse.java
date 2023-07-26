package com.inetum.appliBibliotheque.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString //Lombok
public class VirementResponse {
	
	private Long numCompteDebit;
	private Long numCompteCredit;
	private Double montant;
	private String message; // "vrirement bien effectué" ou "echec"
	private Boolean status; // true si ok, false si echec
	
	
	

}
