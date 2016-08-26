package org.cybercafe.service;

import org.cybercafe.exception.DuplicateVisitorException;
import org.cybercafe.model.Cybercafe;
import org.cybercafe.model.IDCardType;
import org.cybercafe.model.User;
import org.cybercafe.model.Visitor;
import org.cybercafe.repository.VisitorRepository;
import org.cybercafe.utils.CybercafeTestDataUtility;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VisitorServiceTest {
	
	private VisitorService visitorService;
	private Visitor visitor = null;
	
	VisitorRepository mockedVisitorRepository = EasyMock.createMock(VisitorRepository.class);
	
	@Before
	public void setUp(){
		VisitorServiceImpl visitorServiceImpl = new VisitorServiceImpl();
		Cybercafe cybercafe = CybercafeTestDataUtility.getCybercafe();
		IDCardType idCardType = CybercafeTestDataUtility.getIDCardType();
		User user = CybercafeTestDataUtility.getUser();
		visitor = CybercafeTestDataUtility.getVisitor(cybercafe, idCardType, user);
		visitorServiceImpl.setVisitorRepository(mockedVisitorRepository);
		visitorService = visitorServiceImpl;
		
	}
	
	@Test
	public void testSaveVisitor() throws DuplicateVisitorException{
		EasyMock.expect(mockedVisitorRepository.save(visitor)).andReturn(visitor);
		EasyMock.expect(mockedVisitorRepository.findByFirstNameAndLastNameAndMobileAndCybercafe(visitor.getFirstName(), 
				visitor.getLastName(), visitor.getMobile(), visitor.getCybercafe())).andReturn(null);
		EasyMock.expect(mockedVisitorRepository.findByIdCardNumberAndIdCardTypeAndCybercafe(visitor.getIdCardNumber(), 
				visitor.getIdCardType(), visitor.getCybercafe())).andReturn(null);
		EasyMock.replay(mockedVisitorRepository);
		Visitor actualVisitor = visitorService.addVisitor(visitor);
		EasyMock.verify();
		Assert.assertEquals(visitor, actualVisitor);
	}
	
	@Test(expected = DuplicateVisitorException.class)
	public void testSaveVisitorWhenVisitorWithSameNameAndMobileAlreadyExist() throws DuplicateVisitorException {
		EasyMock.expect(mockedVisitorRepository.save(visitor)).andReturn(visitor);
		EasyMock.expect(mockedVisitorRepository.findByFirstNameAndLastNameAndMobileAndCybercafe(visitor.getFirstName(), 
				visitor.getLastName(), visitor.getMobile(), visitor.getCybercafe())).andReturn(visitor);
		EasyMock.expect(mockedVisitorRepository.findByIdCardNumberAndIdCardTypeAndCybercafe(visitor.getIdCardNumber(), 
				visitor.getIdCardType(), visitor.getCybercafe())).andReturn(null);
		EasyMock.replay(mockedVisitorRepository);
		Visitor actualVisitor = visitorService.addVisitor(visitor);
		EasyMock.verify();
		Assert.assertEquals(visitor, actualVisitor);
	}
	
	@Test(expected = DuplicateVisitorException.class)
	public void testSaveVisitorWhenVisitorWithSameIdCardAlreadyExist() throws DuplicateVisitorException {
		EasyMock.expect(mockedVisitorRepository.save(visitor)).andReturn(visitor);
		EasyMock.expect(mockedVisitorRepository.findByFirstNameAndLastNameAndMobileAndCybercafe(visitor.getFirstName(), 
				visitor.getLastName(), visitor.getMobile(), visitor.getCybercafe())).andReturn(null);
		EasyMock.expect(mockedVisitorRepository.findByIdCardNumberAndIdCardTypeAndCybercafe(visitor.getIdCardNumber(), 
				visitor.getIdCardType(), visitor.getCybercafe())).andReturn(visitor);
		EasyMock.replay(mockedVisitorRepository);
		Visitor actualVisitor = visitorService.addVisitor(visitor);
		EasyMock.verify();
		Assert.assertEquals(visitor, actualVisitor);
	}
	
	@Test
	public void testGetIDCardTypes() {
		
	}

}
