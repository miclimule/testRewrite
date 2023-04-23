package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.form.PersonForm;
import com.example.demo.model.Person;

@Controller
public class MainController {

	private static List<Person> persons = new ArrayList<Person>();

	static {
		persons.add(new Person("Bill", "Gates"));
		persons.add(new Person("Steve", "Jobs"));
	}

	
	@Value("${welcome.message}")
	private String message;

	@Value("${error.message}")
	private String errorMessage;

	@GetMapping(value = {"/index" })
	public String index(Model model) {

		model.addAttribute("message", message);

		return "index";
	}

	@GetMapping(value = { "/personList" })
	public String personList(Model model) {

		model.addAttribute("persons", persons);

		return "personList";
	}

	@GetMapping(value = { "/addPerson" })
	public String showAddPersonPage(Model model) {

		PersonForm personForm = new PersonForm();
		model.addAttribute("personForm", personForm);

		return "addPerson";
	}

	@PostMapping(value = { "/addPerson" })
	public String savePerson(Model model, @ModelAttribute("personForm") PersonForm personForm) {

		String firstName = personForm.getFirstName();
		String lastName = personForm.getLastName();

		if (firstName != null && firstName.length() > 0 //
				&& lastName != null && lastName.length() > 0) {
			Person newPerson = new Person(firstName, lastName);
			persons.add(newPerson);

			return "redirect:/personList";
		}

		model.addAttribute("errorMessage", errorMessage);
		return "addPerson";
	}

}