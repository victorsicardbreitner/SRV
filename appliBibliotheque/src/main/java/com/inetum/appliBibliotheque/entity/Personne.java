package com.inetum.appliBibliotheque.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NamedQuery(name="Personne.findByPrenom" , query="SELECT p FROM Personne l WHERE p.prenom = ?1")
@NamedQuery(name="Personne.findByNom" , query="SELECT p FROM Personne l WHERE p.nom = ?1")
@NamedQuery(name="Personne.findByEmail" , query="SELECT p FROM Personne l WHERE p.email = ?1") 
@NamedQuery(name="Personne.findByNumtel" , query="SELECT p FROM Personne l WHERE p.numtel = ?1") 
@NamedQuery(name="Personne.findByVille" , query="SELECT p FROM Personne l WHERE p.ville = ?1") 
@NamedQuery(name="Personne.findByPays" , query="SELECT p FROM Personne l WHERE p.pays = ?1") 

@Getter @Setter @NoArgsConstructor
public class Personne {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String prenom;
	private String nom;
	private String email;
	private String numtel;
	private String numallee;
	private String typevoie;
	private String ville;
	private String codepostal;
	private String pays;

	public Personne(String prenom, String nom, String email, String numtel, String adressecomplete, String numallee,
			String typevoie, String ville, String codepostal, String pays) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.numtel = numtel;
		this.numallee = numallee;
		this.typevoie = typevoie;
		this.ville = ville;
		this.codepostal = codepostal;
		this.pays = pays;
	}
	@Override
	public String toString() {
		return "Personne [prenom=" + prenom + ", nom=" + nom + ", email=" + email + ", numtel=" + numtel
				+ ", numallee=" + numallee + ", typevoie=" + typevoie
				+ ", ville=" + ville + ", codepostal=" + codepostal + ", pays=" + pays + "]";
	}
}
