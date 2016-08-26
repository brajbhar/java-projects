package org.cybercafe.service;

import org.cybercafe.model.Cybercafe;

public interface EMailGeneratorService {
	
	String generateAccountActivationEmailBody(Cybercafe cybercafe);

}
