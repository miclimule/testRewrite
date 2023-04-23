package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
    
//    @Query("select u.id from Utilisateur u WHERE u.email = :email AND u.mdp = :motDePasse")
//	public ArrayList<Object[]> findEmailAndMDP(@Param("email") String email, @Param("motDePasse") String motDePasse);
	
	@Query("SELECT u FROM Utilisateur u WHERE u.email = :#{#utilisateur.email} AND u.mdp = :#{#utilisateur.mdp}")
	public List<Utilisateur> login(@Param("utilisateur") Utilisateur utilisateur);
}
