package org.cybercafe.service;

import org.cybercafe.model.SessionStatus;
import org.cybercafe.repository.SessionStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionStatusServiceImpl implements SessionStatusService {
	
	@Autowired
	private SessionStatusRepository sessionStatusRepository;

	@Override
	public SessionStatus getSessionStatus(Long id) {
		return sessionStatusRepository.findOne(id);
	}

}
