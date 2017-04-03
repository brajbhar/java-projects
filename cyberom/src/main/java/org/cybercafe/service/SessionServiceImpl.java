/**
 * 
 */
package org.cybercafe.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.cybercafe.domain.SystemSearchFilter;
import org.cybercafe.exception.AllSystemsOccupiedException;
import org.cybercafe.model.Session;
import org.cybercafe.model.System;
import org.cybercafe.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @author Bablu
 *
 */
@Service
public class SessionServiceImpl implements SessionService {
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@Autowired
	private SystemService systemService;

	@Override
	public Session createNewSesion(Session session) {
		return sessionRepository.save(session);
	}
	
	@Override
	public Session assignSystem(Session session) throws AllSystemsOccupiedException {
		
		return null;
	}

	private List<System> getAvailableSystems(int numberOfSystems) throws AllSystemsOccupiedException {
		SystemSearchFilter filter = new SystemSearchFilter();
		filter.setPageNumber(1);
		filter.setPageSize(numberOfSystems);
		filter.setGetOnlyAvailableSystems(true);
		Page<System> availableSystems = systemService.getSystems(filter);
		if(CollectionUtils.isEmpty(availableSystems.getContent())) {
			throw new AllSystemsOccupiedException("All systems are occupied");
		}
		return availableSystems.getContent();
	}

	@Override
	public Session updateSession(Session session) {
		return null;
	}

	@Override
	public Session startSession(long sessionId) {
		return null;
	}

	@Override
	public Session completeSession(long sessionId) {
		return null;
	}

	@Override
	public Session getSession(Long id) {
		return sessionRepository.findOne(id);
	}

	@Override
	public Session getSessions() {
		return null;
	}


}
