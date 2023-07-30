package com.inetum.appliBibliotheque.entity;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.inetum.appliBibliotheque.utils.AppUtils;

import lombok.Getter;
import lombok.Setter;

@Entity
//@Table(name = "Emprunt")
@Getter @Setter
public class Emprunt {
	@EmbeddedId
	private EmpruntCompositePk id; // primary key
	
	@ManyToOne
	@MapsId("idLivre")
	@JoinColumn(name = "idLivre", insertable=false, updatable=false)
	private Livre livre;

	@ManyToOne
	@MapsId("idLecteur")
	@JoinColumn(name = "idLecteur", insertable=false, updatable=false)
	private Lecteur lecteur;
	
	
	

	@Temporal(TemporalType.DATE)
	private Date date_debut = new Date();
	@Temporal(TemporalType.DATE)
	private Date date_fin = AppUtils.ajouterJours(date_debut, 14);

	@OneToOne
	@JoinColumn(name = "incident")
	private Incident incident;

	public enum TypesEmprunt {RESERVATION, EFFECTIF};

	@Enumerated(EnumType.STRING)
	private TypesEmprunt etat = TypesEmprunt.EFFECTIF;

	

	public Emprunt() {
		this.id= new EmpruntCompositePk();
	}

	public Emprunt(Livre livre, Lecteur lecteur) {
		this.id= new EmpruntCompositePk(livre.getId(),lecteur.getId());
		this.livre = livre;
		this.lecteur = lecteur;
	}

	// faire un constructeur pour les date_debut et date_fin ?
	
	public void prolonger() { // une semaine
		this.date_fin = AppUtils.ajouterJours(date_fin, 7);
	}

	
}
/*
this.id.setIdLivre(livre.getId());
this.id.setIdLecteur(lecteur.getId());
*/
