package com.inetum.appliBibliotheque.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString //Lombok
public class VirementRequest {
	
	private Long numCompteDebit;
	private Long numCompteCredit;
	private Double montant;
	
	

}
