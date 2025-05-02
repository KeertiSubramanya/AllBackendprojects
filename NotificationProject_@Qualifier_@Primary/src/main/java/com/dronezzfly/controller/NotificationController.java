package com.dronezzfly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dronezzfly.service.MailNotificationService;
import com.dronezzfly.service.NotificationInterface;
import com.dronezzfly.service.SMSNotificationService;

@RestController
@RequestMapping("/notification")
public class NotificationController {
//@Autowired
	//private NotificationService service;
//@Autowired
//@Qualifier("sms") //While using interface class we use these @qualifiers or @primary ,if not below is the method to call 2 function at a time.  
	//@qualifier will let us decide which class should be executed.., whereas we mention @primary in the class which needs to be executed first. 
	
	//private NotificationInterface interface1;
	
	
	/*@Autowired //constructor level dependency injection
	public NotificationController(@Qualifier("mail")NotificationInterface interface1) {
	super();
	this.interface1 = interface1;
	}
	
	
	


@GetMapping("/sent")
	public String SentNotofication() {
		return interface1.SentNotification();
	}*/
	@Autowired
	private SMSNotificationService smsservice;
	@Autowired
	private MailNotificationService mailservice;
	
	//This is the method for calling 2 functions at the same time or to send 2 notification at the same time in this context
	@GetMapping("/sent")
	public String SentNotofication() {
		String s1=smsservice.SentNotification();
		String s2=mailservice.SentNotification();
	return "notification sent"+ " "+s1+ " " +s2;
	}
	
}
