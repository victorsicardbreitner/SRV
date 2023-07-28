package com.inetum.appliBibliotheque.entity;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
//@Table(name = "Emprunt")
@Getter @Setter 
public class Emprunt {
	@EmbeddedId
	private EmpruntCompositePk id; //primary key
	
	
	@Temporal(TemporalType.DATE)
	private Date date_debut = new Date();
	@Temporal(TemporalType.DATE)
	private Date date_fin;
	
	
	public enum TypesEmprunt {RESERVATION, EFFECTIF};
	
	@Enumerated(EnumType.STRING)
	private TypesEmprunt etat = TypesEmprunt.EFFECTIF;
	
	@ManyToOne
	@JoinColumn(name = "livre")
	//@MapsId("idLivre") // pk.idActeur
	private Livre livre;
	
	@ManyToOne
	@JoinColumn(name = "lecteur")
	//@MapsId("idLecteur") // pk.idFilm
	private Lecteur lecteur;

	public Emprunt() {
		super();
		this.id = new EmpruntCompositePk();
	}

	public Emprunt(Livre livre, Lecteur lecteur) {
		super();
		this.livre = livre;
		this.lecteur = lecteur;
		this.id = new EmpruntCompositePk(livre.getId(), lecteur.getId());
	}

	//faire un constructeur pour les date_debut et date_fin ?
}
