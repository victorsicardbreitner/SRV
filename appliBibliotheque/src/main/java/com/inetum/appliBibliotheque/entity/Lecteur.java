package com.inetum.appliBibliotheque.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NamedQuery(name="Lecteur.findById" , query="SELECT lect FROM Lecteur lect")
//@NamedQuery(name="Lecteur.findByNom" , query="SELECT lect FROM Lecteur lect WHERE lect.nom = ?1")

@Entity
@Getter @Setter @NoArgsConstructor
public class Lecteur extends Personne {
	
	private Long idlecteur;

	@Override
	public String toString() {
		return "Lecteur [idlecteur=" + idlecteur + "]";
	}

	public Lecteur(Long id, String prenom, String nom, String email, String numtel, String numallee, String typevoie,
			String ville, String codepostal, String pays, Long idlecteur) {
		super(id, prenom, nom, email, numtel, numallee, typevoie, ville, codepostal, pays);
		this.idlecteur = idlecteur;
	}

	


	
	
	

	
	
}
