package com.dronezzfly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dronezzfly.service.WishMessageService;

@RestController
public class WishMessageController {
	@Autowired //field injection 
	private WishMessageService service;
	
	@Autowired // it is constructor injection 
	public WishMessageController(WishMessageService service) {
		super();
		//System.out.println("it is constructor");
		this.service = service;
	}
	@Autowired //setter injection
	public void setService(WishMessageService service) {
		this.service = service;
	}

@GetMapping("/msg")

	public String wishmsg() {
		return service.wishmsg();
	}

}
