package cn.ucwork.service.impl;

import cn.ucwork.service.SendEmailService;
import cn.ucwork.util.SendJMail;

public class SendEmailServiceImpl implements SendEmailService {

	@Override
	public boolean sendEmail(String getEmail, String emailMsg) {
		if(SendJMail.sendMail(getEmail, emailMsg)){
			return true;
		}else{
			return false;
		}
	}

}
