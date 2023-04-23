package com.example.demo.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Projet")
public class Projet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nom;
	
	private String description;
	
	private Date dateCreation;
	
	private Date deadline;
	
	@OneToMany(mappedBy = "projet")
    private List<Favori> favoris = new ArrayList<>();

	@OneToMany(mappedBy = "projet")
    private List<Projet_Tags> projet_Tags = new ArrayList<>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Projet() {
		super();
	}

	public Projet(long id, String nom, String description, Date dateCreation, Date deadline) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.dateCreation = dateCreation;
		this.deadline = deadline;
	}
	
}
