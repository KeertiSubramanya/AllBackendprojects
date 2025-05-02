package com.dronezzfly.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("mail")
//@Primary
public class MailNotificationService implements NotificationInterface{

	@Override
	public String SentNotification() {
		// TODO Auto-generated method stub
		return "mail sent";
	}

}
