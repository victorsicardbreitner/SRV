package com.inetum.appliBibliotheque.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NamedQuery(name="Lecteur.findById" , query="SELECT lect FROM Lecteur lect")
//@NamedQuery(name="Lecteur.findByNom" , query="SELECT lect FROM Lecteur lect WHERE lect.nom = ?1")

@Entity
//@Table(name = "Lecteur")
@Getter @Setter @NoArgsConstructor
public class Lecteur extends Personne {
	
	
	public Lecteur(String prenom, String nom) {
		super(prenom, nom);
	}

	public Lecteur(Long id, String prenom, String nom, String email, String numtel, String numallee, String typevoie,
			String ville, String codepostal, String pays, Long idlecteur) {
		super(id, prenom, nom, email, numtel, numallee, typevoie, ville, codepostal, pays);
	}
	
	
	
	@OneToMany(mappedBy="lecteur" /*, cascade = CascadeType.ALL*/)
	private List<Emprunt> emprunts;
	

	


	
	
	

	
	
}
