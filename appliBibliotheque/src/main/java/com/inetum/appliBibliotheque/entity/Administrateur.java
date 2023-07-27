package com.inetum.appliBibliotheque.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NamedQuery(name="Admin.findByNom" , query="SELECT admin FROM Administrateur adm WHERE adm.idadmin = ?1")

@Getter @Setter @NoArgsConstructor
public class Administrateur extends Personne {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idadmin;
	private String username;
	private String password;
	
	public Administrateur(String prenom, String nom, String email, String numtel, String adressecomplete,
			String numallee, String typevoie, String ville, String codepostal, String pays, Long idadmin,
			String username, String password) {
		super(prenom, nom, email, numtel, adressecomplete, numallee, typevoie, ville, codepostal, pays);
		this.idadmin = idadmin;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Administrateur [idadmin=" + idadmin + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
