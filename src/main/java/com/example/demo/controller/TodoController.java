package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {

	@GetMapping(value = { "/" })
	private String Hello(String nom) {
		return "index";
	}
	
	
}
