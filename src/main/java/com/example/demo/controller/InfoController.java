package com.example.demo.controller;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Favori;
import com.example.demo.model.Projet;
import com.example.demo.model.Projet_Tags;
import com.example.demo.model.Tache;
import com.example.demo.model.Tags;
import com.example.demo.model.Utilisateur;
import com.example.demo.model.Utilisateur_Projet;
import com.example.demo.repository.FavorieRepository;
import com.example.demo.repository.ProjetRepository;
import com.example.demo.repository.Projet_TagsRepository;
import com.example.demo.repository.TacheRepository;
import com.example.demo.repository.TagsRepository;
import com.example.demo.repository.UtilisateurRepository;
import com.example.demo.repository.Utilisateur_ProjectRepository;



@RestController
public class InfoController {

	@Autowired
	FavorieRepository favorieRepository;
	@Autowired
	Projet_TagsRepository projet_TagsRepository;
	@Autowired
	ProjetRepository projetRepository;
	@Autowired
	TacheRepository tacheRepository;
	@Autowired
	TagsRepository tagsRepository;
	@Autowired
	Utilisateur_ProjectRepository utilisateur_ProjectRepository;
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	
	@GetMapping("/favorie")
	private List<Favori> getFavorie() {
		return favorieRepository.findAll();
	}
	
	@GetMapping("/projet_tags")
	private List<Projet_Tags> getProjetTags() {
		return projet_TagsRepository.findAll();
	}
	
	@GetMapping("/projet")
	private List<Projet> getProjet() {
		return projetRepository.findAll();
	}
	
	@GetMapping("/tache")
	private List<Tache> getTache() {
		return tacheRepository.findAll();
	}
	
	@GetMapping("/tags")
	private List<Tags> getTags() {
		return tagsRepository.findAll();
	}
	
	@GetMapping("/utilisateur_projet")
	private List<Utilisateur_Projet> getUtilisateurProjet() {
		return utilisateur_ProjectRepository.findAll();
	}
	
	@GetMapping("/utilisateur")
	private List<Utilisateur> getUtilisateur() {
		return utilisateurRepository.findAll();
	}
	
	@PostMapping("/login")
	private List<Utilisateur> login(String email , String mdp) throws NoSuchAlgorithmException {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setEmail(email);
		utilisateur.setMdp(mdp);
		return utilisateurRepository.login(utilisateur);
	}
	
	@PostMapping("/utilisateur")
	private void setUtilisateur(String nom , String prenom ,String email , String mdp) throws NoSuchAlgorithmException {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateur.setEmail(email);
		utilisateur.setMdp(mdp);
		utilisateurRepository.save(utilisateur);
	}
	
}
