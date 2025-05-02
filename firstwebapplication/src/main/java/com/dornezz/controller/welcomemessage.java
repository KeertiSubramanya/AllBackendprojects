package com.dornezz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1") //base path to avoid conflict
public class welcomemessage { //Renamed for better clarity
	
	@GetMapping("/welcomemsg")
	public String welcome() {
		return "hello good morning";
	}

}

