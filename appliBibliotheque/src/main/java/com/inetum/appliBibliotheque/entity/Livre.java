package com.inetum.appliBibliotheque.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

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
	
	public Livre(Long id, String titre, String auteur) {
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + "]";
	}
	
	
	@OneToMany(mappedBy="livre" /*, cascade = CascadeType.ALL*/)
	private List<Emprunt> emprunts;
	

}
