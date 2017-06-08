/**
 * 
 */
package org.cybercafe.service;


import java.util.Date;

import org.apache.commons.collections4.CollectionUtils;
import org.cybercafe.AbstractTest;
import org.cybercafe.model.Cybercafe;
import org.cybercafe.model.IDCardType;
import org.cybercafe.model.Session;
import org.cybercafe.model.SessionStatus;
import org.cybercafe.model.User;
import org.cybercafe.model.Visitor;
import org.cybercafe.utils.CybercafeTestDataUtility;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
	
	@Test
	public void testCreateNewSession() {
		Cybercafe cybercafe = CybercafeTestDataUtility.getCybercafe();
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
		Cybercafe cybercafe = CybercafeTestDataUtility.getCybercafe();
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
	public void testAssignSystem() {
		
	}
	
	public Session createNewSession(Cybercafe cybercafe) {
		User user = CybercafeTestDataUtility.getUser();
		IDCardType idCardType = CybercafeTestDataUtility.getIDCardType();
		Visitor visitor = CybercafeTestDataUtility.getVisitor(cybercafe, idCardType, user);
		Session newSession = CybercafeTestDataUtility.getSession(cybercafe, visitor, user, 
				null, sessionStatusService.getSessionStatus(1L));
		Session savedSession = sessionService.createNewSesion(newSession, cybercafe, user);
		return savedSession;
	}

}
