package org.cybercafe.service;

import org.cybercafe.model.Cybercafe;
import org.cybercafe.model.User;

public interface CybercafeService {

	Cybercafe register(Cybercafe cybercafe) throws Exception;
	
	Cybercafe getCybercafe(Long id) throws Exception;
	
	Cybercafe getCybercafe(String username);

}
