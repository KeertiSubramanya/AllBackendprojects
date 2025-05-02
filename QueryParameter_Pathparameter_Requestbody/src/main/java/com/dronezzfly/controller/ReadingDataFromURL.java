package com.dronezzfly.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dronezzfly.dto.RequestDTO;

@RestController
@RequestMapping("/student")
public class ReadingDataFromURL {
	
	@GetMapping("/reading")  //Query Parameter  localhost:8080/student/reading?id=101&name=keerti
	public String readValuesFromUrl(@RequestParam String id,@RequestParam String name,@RequestParam String course) {
		String result=" ID: " +id+ " Name: " +name+ " Course: " +course; 
		return result;
	}

	@GetMapping("/reading/{id}/{name}/{course}")  //Path Parameter  localhost:8080/student/reading/101/keerti
	public String readValuesFromUrlUsingPathParameter(@PathVariable String id,@PathVariable String name,@PathVariable String course) {
		String result=" ID: " +id+ " Name: " +name+ " Course: " +course; 
		return result;
	}
	
	//Request body
	@PostMapping("/details")
	public String showdetails(@RequestBody RequestDTO requestDTO) {
		return "ID:"+requestDTO.getId()+" Name:"+requestDTO.getName()+" Course"+requestDTO.getCourse()+" Age:"+requestDTO.getAge()+" Mobile:"+requestDTO.getMobile();
		
	}
}

