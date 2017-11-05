/**
 * 
 */
package org.cybercafe.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.cybercafe.domain.SessionSearchFilter;
import org.cybercafe.exception.AllSystemsOccupiedException;
import org.cybercafe.model.Cybercafe;
import org.cybercafe.model.Session;
import org.cybercafe.model.SessionStatus;
import org.cybercafe.model.User;
import org.cybercafe.repository.SessionRepository;
import org.cybercafe.repository.SessionSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	private SessionStatusService sessionStatusService;
	
	@Override
	public Session createNewSesion(Session session, Cybercafe cybercafe, User user) {
		Date currentDate = new Date();
		session.setCreatedOn(currentDate);
		session.setUpdatedOn(currentDate);
		session.setCybercafe(cybercafe);
		session.setStartTime(currentDate);
		session.setSessionStatus(sessionStatusService.getNewStatus());
		session.setUpdatedBy(user);
		return sessionRepository.save(session);
	}
	
	@Override
	public Session assignSystem(Session session) throws AllSystemsOccupiedException {
		return null;
	}


	@Override
	public Session updateSession(Session session) {
		return null;
	}

	@Override
	public Session startSession(long sessionId, Date startTime, SessionStatus sessionStatus) {
		Session session = sessionRepository.findOne(sessionId);
		session.setStartTime(startTime);
		session.setSessionStatus(sessionStatus);
		return sessionRepository.save(session);
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
	public Page<Session> getSessions(SessionSearchFilter filter) {
		SessionSpecification specification = new SessionSpecification(filter);
		PageRequest pageRequest = new PageRequest(filter.getPageNumber(), filter.getPageSize());
		return sessionRepository.findAll(specification, pageRequest);
	}

	@Override
	public void completeSessions() {
		List<Session> sessions = sessionRepository.findBySessionStatus(
				sessionStatusService.getInProgressStatus());
		List<Session> completedSessions = new ArrayList<>();
		for(Session session : sessions) {
			int bookingDuration = session.getBookingDuration();
			Date startTime = session.getStartTime();
			if(isSessionCompleted(startTime, bookingDuration)) {
				session.setSessionStatus(sessionStatusService.getCompletedStatus());
				session.setEndTime(new Date());
				completedSessions.add(session);
			}
		}
		sessionRepository.save(completedSessions);
	}

	private boolean isSessionCompleted(Date startTime, int bookingDuration) {
		Date currentTime = new Date();
		long timeDifferenceInMinutes = TimeUnit.MILLISECONDS.toMinutes(currentTime.getTime() - startTime.getTime());
		return timeDifferenceInMinutes >= bookingDuration;
	}


}
