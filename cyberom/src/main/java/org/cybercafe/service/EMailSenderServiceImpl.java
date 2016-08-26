package org.cybercafe.service;

import org.cybercafe.model.Cybercafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EMailSenderServiceImpl implements EMailSenderService {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	@Autowired
	EMailGeneratorService emailGenerator;

	private static final String SUBJECT = "Activate your CyberOM account";

	private static final String FROM_EMAIL_ADDRESS = "bablu.rajbhar87@gmail.com";

	@Override
	public void sendAccountActivationEMail(Cybercafe cybercafe) {
		
		sendEmail(FROM_EMAIL_ADDRESS, cybercafe.getUser().getEmail(),
				SUBJECT, emailGenerator.generateAccountActivationEmailBody(cybercafe));
	}
	
	private void sendEmail(String from, String to, String subject,String content) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(content);
		javaMailSender.send(message);
		
	}

	
	
	

}
