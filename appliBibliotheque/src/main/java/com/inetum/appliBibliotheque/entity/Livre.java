package com.inetum.appliBibliotheque.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Table(name = "Livre")
@NamedQuery(name="Livre.findByTitre" , query="SELECT l FROM Livre l WHERE l.titre = ?1") 
@Getter @Setter @NoArgsConstructor
public class Livre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	private String titre;
	private String auteur;
	private Boolean dispo;
	
	public enum EtatLivre { BON_ETAT,ABIME,HORS_SERVICE };
	
	@Enumerated(EnumType.STRING)
	private EtatLivre etat = EtatLivre.BON_ETAT;
	
	public Livre(Long id, String titre, String auteur, Boolean dispo) {
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.dispo = dispo;
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + " dispo "+ dispo+ "]";
	}
	
	
	@OneToMany(mappedBy="livre" /*, cascade = CascadeType.ALL*/)
	@JsonIgnore
	private List<Emprunt> emprunts;
	

}
