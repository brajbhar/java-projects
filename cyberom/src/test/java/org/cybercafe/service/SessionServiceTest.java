/**
 * 
 */
package org.cybercafe.service;


import java.util.Date;

import org.apache.commons.collections4.CollectionUtils;
import org.cybercafe.AbstractTest;
import org.cybercafe.domain.SessionSearchFilter;
import org.cybercafe.model.Cybercafe;
import org.cybercafe.model.IDCardType;
import org.cybercafe.model.Session;
import org.cybercafe.model.SessionStatus;
import org.cybercafe.model.User;
import org.cybercafe.model.Visitor;
import org.cybercafe.utils.CybercafeTestDataUtility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

/**
 * @author Bablu
 *
 */
public class SessionServiceTest extends AbstractTest {
	
	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private SessionStatusService sessionStatusService;
	
	@Autowired
	private SystemService systemService;
	
	@Autowired
	private VisitorService visitorService;
	
	@Autowired
	private CybercafeService cybercafeService;
	

	private Cybercafe cybercafe;
	
	private Visitor visitor;
	
	@Before
	public void setUp() throws Exception {
		cybercafe = cybercafeService.getCybercafe(1L);
		visitor = visitorService.getVisitor(1L);
	}
	
	@Test
	public void testCreateNewSession() {
		Session savedSession = createNewSession(cybercafe);
		Assert.assertNotNull(savedSession);
		Long sessionId = savedSession.getId();
		savedSession = sessionService.getSession(sessionId);
		Assert.assertNotNull(savedSession);
		Assert.assertEquals(sessionId, savedSession.getId());
		Assert.assertEquals(cybercafe, savedSession.getCybercafe());
		Assert.assertTrue(CollectionUtils.isEmpty(savedSession.getSystemUsages()));
	}
	
	@Test
	public void testStartSession() {
		Session savedSession = createNewSession(cybercafe);
		Assert.assertNotNull(savedSession);
		Date sessionStartTime = new Date();
		SessionStatus sessionStatusInProgress = sessionStatusService.getSessionStatus(2L);
		Session startedSession = sessionService.startSession(savedSession.getId(), 
				sessionStartTime, sessionStatusInProgress);
		Assert.assertNotNull(startedSession);
		Assert.assertEquals(sessionStartTime, startedSession.getStartTime());
		Assert.assertEquals(sessionStatusInProgress, startedSession.getSessionStatus());
		
	}
	
	@Test
	public void testGetSessionsByCybercafe() {
		SessionSearchFilter filter = new SessionSearchFilter();
		filter.setCybercafe(cybercafe);
		filter.setPageNumber(1);
		filter.setPageSize(10);
		Session savedSession = createNewSession(cybercafe);
		Assert.assertNotNull(savedSession);
		
		Page<Session> sessions = sessionService.getSessions(filter);
		Assert.assertNotNull(sessions);
		Assert.assertTrue(sessions.getSize() <= 10);
		for(Session session : sessions) {
			Assert.assertNotNull(session.getCybercafe());
			Assert.assertEquals(cybercafe, session.getCybercafe());
		}
		
	}
	
	@Test
	public void testAssignSystem() {
		
	}
	
	public Session createNewSession(Cybercafe cybercafe) {
		User user = CybercafeTestDataUtility.getUser();
		Session newSession = CybercafeTestDataUtility.getSession(cybercafe, visitor, user, 
				null, sessionStatusService.getSessionStatus(1L));
		Session savedSession = sessionService.createNewSesion(newSession, cybercafe, user);
		return savedSession;
	}

}
