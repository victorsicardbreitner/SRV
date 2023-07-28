package com.inetum.appliBibliotheque.entity;

import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Domaine {

	public Domaine(Long id, String nom, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	private String description;
	
	@JsonIgnore 
 	@OneToMany(fetch=FetchType.LAZY,mappedBy="domaine")//, cascade = CascadeType.ALL)
	private List<Livre> livres;
	
	
	
}
