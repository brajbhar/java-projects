/**
 * 
 */
package org.cybercafe.repository;

import org.cybercafe.AbstractRepositoryTest;
import org.cybercafe.model.Cybercafe;
import org.cybercafe.model.IDCardType;
import org.cybercafe.model.Session;
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
public class SessionRepositoryTest extends AbstractRepositoryTest {
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@Autowired
	private SystemRepository systemRepository;
	
	@Autowired
	private SessionStatusRepository sessionStatusRepository;
	
	@Test
	public void testSaveSession() {
		Cybercafe cybercafe = CybercafeTestDataUtility.getCybercafe();
		User user = CybercafeTestDataUtility.getUser();
		IDCardType idCardType = CybercafeTestDataUtility.getIDCardType();
		Visitor visitor = CybercafeTestDataUtility.getVisitor(cybercafe, idCardType, user);
		Session newSession = CybercafeTestDataUtility.getSession(cybercafe, visitor, user, 
				systemRepository.findOne(1L), sessionStatusRepository.findOne(1L));
		Session savedSession = sessionRepository.save(newSession);
		Assert.assertNotNull(savedSession);
		Assert.assertEquals(newSession.getCybercafe(), savedSession.getCybercafe());
		Assert.assertEquals(newSession.getSessionStatus(), savedSession.getSessionStatus());
		Assert.assertNotNull(savedSession.getSystemUsages());
		Assert.assertTrue(savedSession.getSystemUsages().size() > 0);
		Assert.assertEquals(savedSession.getSystemUsages().size(), newSession.getSystemUsages().size());
		
	}
	
	@Test
	public void testSaveSessionWithoutSystemUsage() {
		Cybercafe cybercafe = CybercafeTestDataUtility.getCybercafe();
		User user = CybercafeTestDataUtility.getUser();
		IDCardType idCardType = CybercafeTestDataUtility.getIDCardType();
		Visitor visitor = CybercafeTestDataUtility.getVisitor(cybercafe, idCardType, user);
		Session newSession = CybercafeTestDataUtility.getSession(cybercafe, visitor, user, 
				null, sessionStatusRepository.findOne(1L));
		Session savedSession = sessionRepository.save(newSession);
		Assert.assertNotNull(savedSession);
		Assert.assertEquals(newSession.getCybercafe(), savedSession.getCybercafe());
		Assert.assertEquals(newSession.getSessionStatus(), savedSession.getSessionStatus());
		Assert.assertNull(savedSession.getSystemUsages());
		
	}
	
	

}
