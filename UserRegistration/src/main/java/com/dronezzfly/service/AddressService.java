package com.dronezzfly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.dronezzfly.repository.AddressRepo;
import com.dronezzfly.requestdto.AddressRequestDTO;

@Service
public class AddressService {
	@Autowired
	private AddressRepo addressrepo;

	public ResponseEntity<String> saveAddress(AddressRequestDTO addreqdto) {
		// TODO Auto-generated method stub
		return null;
	}


}
