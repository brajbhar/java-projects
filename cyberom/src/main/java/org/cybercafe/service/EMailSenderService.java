package org.cybercafe.service;

import org.cybercafe.model.Cybercafe;

public interface EMailSenderService {
	
	public void sendAccountActivationEMail(Cybercafe cybercafe);
}
