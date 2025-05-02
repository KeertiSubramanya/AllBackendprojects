package com.dronezzfly.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customproperties")
public class CustomProperties {
	@Autowired
	private CustomConfigurationProperties preConfigurationProperties;
	
	@Value("${app.name}")
	private String appName;
	@Value("${app.version}")
	private String version;
	@Value("${app.description}")
	private String description;
	
	@GetMapping("/values")
	public String showProperties() {
		return "appname:"+appName+"version"+version+"description"+description;
	}
	
	@GetMapping("/custom")
	public String display() {
			return "Student id:"+preConfigurationProperties.getId()+"Student name:"+preConfigurationProperties.getName()+"Student age:"+preConfigurationProperties.getAge()+"Student course:"+preConfigurationProperties.getCourse();	}
	
}
