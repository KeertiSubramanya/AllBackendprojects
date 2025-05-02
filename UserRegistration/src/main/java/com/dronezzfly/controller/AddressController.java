package com.dronezzfly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dronezzfly.requestdto.AddressRequestDTO;
import com.dronezzfly.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	private AddressService addressservice;
	@PostMapping("/save")
	public ResponseEntity<String> saveAdress(@RequestBody AddressRequestDTO addreqdto){
		return addressservice.saveAddress(addreqdto);
	}
}
