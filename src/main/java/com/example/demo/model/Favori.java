package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Favori")
public class Favori {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
//	@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne
    @JoinColumn(name = "Projetid")
    private Projet projet;

    @ManyToOne
    @JoinColumn(name = "utilisateurid")
    private Utilisateur utilisateur;

	public Favori() {
		super();
	}

	public Favori(long id, Projet projet, Utilisateur utilisateur) {
		super();
		this.id = id;
		this.projet = projet;
		this.utilisateur = utilisateur;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
}
