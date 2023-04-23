package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Projet_Tags")
public class Projet_Tags {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "Projetid")
	Projet projet;
	
	@ManyToOne
	@JoinColumn(name = "Tagsid")
	Tags tags;
	
	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Tags getTags() {
		return tags;
	}

	public void setTags(Tags tags) {
		this.tags = tags;
	}

	public Projet_Tags() {
		super();
	}

	public Projet_Tags(Projet projet, Tags tags) {
		super();
		this.projet = projet;
		this.tags = tags;
	}
}
