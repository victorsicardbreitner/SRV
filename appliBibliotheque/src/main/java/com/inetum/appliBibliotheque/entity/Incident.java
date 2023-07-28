package com.inetum.appliBibliotheque.entity;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Incident {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String motif;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "id_livre"),
		@JoinColumn(name = "id_lecteur")
	})
	Emprunt emprunt;

	public Incident(String motif) {
		super();
		this.motif = motif;
	}

	@Override
	public String toString() {
		return "Incident [motif=" + motif+"]";
	}
	
	
}
/*
@JoinColumns({
@JoinColumn(name = "livre"),
@JoinColumn(name = "lecteur")
})
*/