package org.cybercafe.service;

import org.cybercafe.model.SessionStatus;
import org.cybercafe.repository.SessionStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionStatusServiceImpl implements SessionStatusService {
	
	public static Long NEW_STATUS_ID = 1L;
	
	public static Long IN_PROGRESS_STATUS_ID = 2L;
	
	public static Long COMPLETED_STATUS_ID = 3L;
	
	@Autowired
	private SessionStatusRepository sessionStatusRepository;

	@Override
	public SessionStatus getSessionStatus(Long id) {
		return sessionStatusRepository.findOne(id);
	}

	@Override
	public SessionStatus getInProgressStatus() {
		return getSessionStatus(IN_PROGRESS_STATUS_ID);
	}

	@Override
	public SessionStatus getNewStatus() {
		return getSessionStatus(NEW_STATUS_ID);
	}

	@Override
	public SessionStatus getCompletedStatus() {
		return getSessionStatus(COMPLETED_STATUS_ID);
	}

}
