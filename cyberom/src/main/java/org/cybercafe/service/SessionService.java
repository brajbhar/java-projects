package org.cybercafe.service;

import org.cybercafe.exception.AllSystemsOccupiedException;
import org.cybercafe.model.Session;

public interface SessionService {
	
	Session createNewSesion(Session session);
	
	Session assignSystem(Session session) throws AllSystemsOccupiedException;
	
	Session startSession(long sessionId);
	
	Session updateSession(Session session);
	
	Session completeSession(long sessionId);
	
	Session getSession(Long id);
	
	Session getSessions();

}
