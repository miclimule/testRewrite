package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Tags;

public interface TagsRepository extends JpaRepository<Tags, Long>{

}
