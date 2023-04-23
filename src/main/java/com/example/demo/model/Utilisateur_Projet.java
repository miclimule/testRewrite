package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Utilisateur_Projet")
public class Utilisateur_Projet {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "Utilisateurid")
	private Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name = "Projetid")
	private Projet projet;

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Utilisateur_Projet(Utilisateur utilisateur, Projet projet) {
		super();
		this.utilisateur = utilisateur;
		this.projet = projet;
	}

	public Utilisateur_Projet() {
		super();
	}
	
}
