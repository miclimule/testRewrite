package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.security.*;
@Entity
@Table(name="utilisateur")
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nom;
	
	private String prenom;
	
	private String email;
	
	private String mdp;

	@OneToMany(mappedBy = "utilisateur")
    private List<Favori> favoris = new ArrayList<>();
	
	@OneToMany(mappedBy = "utilisateur")
    private List<Tache> Tache = new ArrayList<>();
	
	public Utilisateur() {
		super();
	}

	public Utilisateur(long id, String nom, String prenom, String email, String mdp) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
	}

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

//	MD2
//	MD5
//	SHA-1
//	SHA-224
//	SHA-256
//	SHA-384
//	SHA-512
//	SHA-512/224
//	SHA-512/256
	public void setMdp(String mdp) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("MD5");
		byte[] hash = digest.digest(mdp.getBytes());
        String hexHash = bytesToHex(hash);
		this.mdp = hexHash;
	}
	
	private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
