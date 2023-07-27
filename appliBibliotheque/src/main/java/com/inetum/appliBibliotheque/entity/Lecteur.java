package com.inetum.appliBibliotheque.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NamedQuery(name="Lecteur.findById" , query="SELECT lect FROM Lecteur lect WHERE lect.id = ?1")
@NamedQuery(name="Lecteur.findByNom" , query="SELECT lect FROM Lecteur lect WHERE lect.nom = ?1")

@Getter @Setter @NoArgsConstructor
public class Lecteur extends Personne {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlecteur;
	
	public Lecteur(String prenom, String nom, String email, String numtel, String adressecomplete, String numallee,
			String typevoie, String ville, String codepostal, String pays, Long idlecteur) {
		super(prenom, nom, email, numtel, adressecomplete, numallee, typevoie, ville, codepostal, pays);
		this.idlecteur = idlecteur;
	}

	@Override
	public String toString() {
		return "Lecteur [idlecteur=" + idlecteur + "]";
	}
	
	
}
