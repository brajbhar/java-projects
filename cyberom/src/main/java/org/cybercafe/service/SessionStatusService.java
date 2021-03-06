package org.cybercafe.service;

import org.cybercafe.model.SessionStatus;

public interface SessionStatusService {
	
	SessionStatus getSessionStatus(Long id);
	
	SessionStatus getInProgressStatus();
	
	SessionStatus getNewStatus();
	
	SessionStatus getCompletedStatus();

}
