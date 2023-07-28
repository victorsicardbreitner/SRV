package com.inetum.appliBibliotheque.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter @Setter @NoArgsConstructor
public class EmpruntCompositePk implements Serializable {
	private static final long serialVersionUID = 1L;
	private long idLivre;
	private long idLecteur;

	public EmpruntCompositePk(long idLivre, long idLecteur) {
		super();
		this.idLivre = idLivre;
		this.idLecteur = idLecteur;
	}

	@Override
	public String toString() {
		return "EmpruntCompositePk [idLivre=" + idLivre + ", idLecteur=" + idLecteur + "]";
	}
	
	
//+get/set , equals et hashcode (generated by eclipse)
	
	
}