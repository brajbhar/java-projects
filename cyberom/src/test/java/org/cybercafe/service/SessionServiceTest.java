/**
 * 
 */
package org.cybercafe.service;

import org.apache.commons.collections4.CollectionUtils;
import org.cybercafe.AbstractTest;
import org.cybercafe.domain.SystemSearchFilter;
import org.cybercafe.model.Cybercafe;
import org.cybercafe.model.IDCardType;
import org.cybercafe.model.Session;
import org.cybercafe.model.System;
import org.cybercafe.model.User;
import org.cybercafe.model.Visitor;
import org.cybercafe.utils.CybercafeTestDataUtility;
import org.junit.Assert;
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
	
	@Test
	public void testCreateNewSession() {
		Cybercafe cybercafe = CybercafeTestDataUtility.getCybercafe();
		User user = CybercafeTestDataUtility.getUser();
		IDCardType idCardType = CybercafeTestDataUtility.getIDCardType();
		Visitor visitor = CybercafeTestDataUtility.getVisitor(cybercafe, idCardType, user);
		Session newSession = CybercafeTestDataUtility.getSession(cybercafe, visitor, user, 
				null, sessionStatusService.getSessionStatus(1L));
		Session savedSession = sessionService.createNewSesion(newSession);
		Assert.assertNotNull(savedSession);
		Long sessionId = savedSession.getId();
		savedSession = sessionService.getSession(sessionId);
		Assert.assertNotNull(savedSession);
		Assert.assertEquals(sessionId, savedSession.getId());
		Assert.assertEquals(cybercafe, savedSession.getCybercafe());
		Assert.assertTrue(CollectionUtils.isEmpty(savedSession.getSystemUsages()));
	}
	
	@Test
	public void testAssignSystem() {
		
	}

}
