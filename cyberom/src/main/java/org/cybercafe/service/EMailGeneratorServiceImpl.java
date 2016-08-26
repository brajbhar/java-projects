package org.cybercafe.service;

import org.cybercafe.model.Cybercafe;
import org.springframework.stereotype.Service;

@Service
public class EMailGeneratorServiceImpl implements EMailGeneratorService {
	
	private static final String THANSK_REGARDS = "Thansk & Regards";

	private static final String ORGANISATION_NAME = "CyberOM";

	private static final String ACTIVATION_EMAIL_MESSAGE = " Thanks for registering with us. Please click on the below link to activate your account :";

	private static final String SALUTATION = "Hi ";

	private static final String ACTIVATION_URL = "http://localhost:8080/cyberom/activateAccount?id=";

	private static final String COMMA = ",";
	
	private static final String NEW_LINE = "\n";
	
	private static final String TAB = "\t";

	@Override
	public String generateAccountActivationEmailBody(Cybercafe cybercafe) {
		String message = SALUTATION + cybercafe.getUser().getFirstName() + COMMA + NEW_LINE + NEW_LINE +
				TAB + ACTIVATION_EMAIL_MESSAGE + NEW_LINE + NEW_LINE + 
				generateActivationURL(cybercafe) + NEW_LINE + NEW_LINE +
				THANSK_REGARDS+ COMMA + NEW_LINE +
				ORGANISATION_NAME;
		return message;
	}
	
	private String generateActivationURL(Cybercafe cybercafe) {
		return ACTIVATION_URL + cybercafe.getUser().getRandomUUID();
	}

}
