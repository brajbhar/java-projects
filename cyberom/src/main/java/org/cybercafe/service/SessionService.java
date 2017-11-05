package org.cybercafe.service;

import java.util.Date;

import org.cybercafe.domain.SessionSearchFilter;
import org.cybercafe.exception.AllSystemsOccupiedException;
import org.cybercafe.model.Cybercafe;
import org.cybercafe.model.Session;
import org.cybercafe.model.SessionStatus;
import org.cybercafe.model.User;
import org.springframework.data.domain.Page;

public interface SessionService {
	
	Session createNewSesion(Session session, Cybercafe cybercafe, User user);
	
	Session assignSystem(Session session) throws AllSystemsOccupiedException;
	
	Session startSession(long sessionId, Date startDate, SessionStatus sessionStatus);
	
	Session updateSession(Session session);
	
	Session completeSession(long sessionId);
	
	void completeSessions();
	
	Session getSession(Long id);
	
	Page<Session> getSessions(SessionSearchFilter filter);

}
