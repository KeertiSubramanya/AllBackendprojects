package com.dronezzfly.service;

import org.springframework.stereotype.Service;

@Service("outlook")
public class Outlookmmailservice implements NotificationInterface{

	@Override
	public String SentNotification() {
		// TODO Auto-generated method stub
		return "outlook mail sent";
	}

}
