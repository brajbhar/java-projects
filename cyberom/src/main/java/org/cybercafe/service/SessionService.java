package org.cybercafe.service;

import java.util.Date;

import org.cybercafe.exception.AllSystemsOccupiedException;
import org.cybercafe.model.Cybercafe;
import org.cybercafe.model.Session;
import org.cybercafe.model.SessionStatus;
import org.cybercafe.model.User;

public interface SessionService {
	
	Session createNewSesion(Session session, Cybercafe cybercafe, User user);
	
	Session assignSystem(Session session) throws AllSystemsOccupiedException;
	
	Session startSession(long sessionId, Date startDate, SessionStatus sessionStatus);
	
	Session updateSession(Session session);
	
	Session completeSession(long sessionId);
	
	Session getSession(Long id);
	
	Session getSessions();

}
