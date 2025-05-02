package com.dronezzfly.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/properties")
public class Properties {
	@Autowired
	private CustomConfigPropForEmp preConfigurationProperties;
	
	@Value("${employee.id}")
	private String empID;
	@Value("${employee.name}")
	private String empName;
	@Value("${employee.dept}")
	private String empdept;
	@Value("${employee.salary}")
	private String empsalary;
	
	
	@GetMapping("/values")  //method level url mapping
	public String showProperties() {
		return "empID: "+empID+" emp name:"+empName+" emp dept:"+empdept+" emp salary:"+empsalary;
	}
	
	@GetMapping("/custom") //post
	public String display() {
			return "Emp id: "+preConfigurationProperties.getId()+" Emp name:"+preConfigurationProperties.getName()+" Emp dept:"+preConfigurationProperties.getDept()+" Emp salary:"+preConfigurationProperties.getSalary();	}
	
}

