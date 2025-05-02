package com.dronezzfly.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("sms")
//@Primary
public class SMSNotificationService implements NotificationInterface{

	@Override
	public String SentNotification() {
		// TODO Auto-generated method stub
		return "sms sent";
	}

}
