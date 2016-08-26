/**
 * 
 */
package org.cybercafe.service;

import org.cybercafe.AbstractTest;
import org.cybercafe.exception.DuplicateUserEmailException;
import org.cybercafe.model.Cybercafe;
import org.cybercafe.repository.CybercafeRepository;
import org.cybercafe.repository.StatusRepository;
import org.cybercafe.utils.CybercafeTestDataUtility;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author Bablu Rajbhar
 *
 */
public class CybercafeServiceTest extends AbstractTest {
	
	CybercafeService cybercafeService;
	
	CybercafeRepository cybercafeRepository;
	
	StatusRepository statusRepository;
	
	@Autowired
	EMailSenderService emailService;
	
	@Autowired
	EMailGeneratorService emailGeneratorService;
	
	@Autowired
	UserService userService;
	
	
	@Before
	public void before() {
		
		cybercafeRepository = EasyMock.createMock(CybercafeRepository.class);
		statusRepository = EasyMock.createMock(StatusRepository.class);
		emailService = EasyMock.createMock(EMailSenderService.class);
		userService = EasyMock.createMock(UserService.class);
		emailService.sendAccountActivationEMail(CybercafeTestDataUtility.getCybercafe());
		EasyMock.expectLastCall();
		CybercafeServiceImpl cybercafeServiceImpl = new CybercafeServiceImpl();
		cybercafeServiceImpl
			.setCybercafeRepository(cybercafeRepository);
		cybercafeServiceImpl.setStatusRepository(statusRepository);
		cybercafeServiceImpl.setEmailService(emailService);
		cybercafeServiceImpl.setEmailGenerator(emailGeneratorService);
		cybercafeServiceImpl.setUserService(userService);
		cybercafeService = cybercafeServiceImpl;
	}
	
	@Test
	public void testRegisterCybercafe() throws Exception {
		
		Cybercafe expectedCybercafe = CybercafeTestDataUtility.getCybercafe();
		EasyMock.expect(userService.getUserByEmail(CybercafeTestDataUtility.EMAIL_ADDRESS)).andReturn(null);
		EasyMock.expect(userService.getUserByUserName(CybercafeTestDataUtility.USER_NAME)).andReturn(null);
		EasyMock.expect(cybercafeRepository.save(expectedCybercafe)).andReturn(expectedCybercafe);
		EasyMock.expect(statusRepository.findOneByName("inactive"))
			.andReturn(CybercafeTestDataUtility.getInActiveStatus());
		EasyMock.expect(statusRepository.findOneByName("inactive"))
			.andReturn(CybercafeTestDataUtility.getInActiveStatus());
		EasyMock.replay(userService, cybercafeRepository, statusRepository);
		CybercafeTestDataUtility.assertCybercafe(expectedCybercafe, 
				cybercafeService.register(expectedCybercafe));
		
	}
	
	@Test(expected = DuplicateUserEmailException.class)
	public void testRegisterCybercafeWithDuplicateEmailAddress() throws Exception {
		Cybercafe cybercafe = CybercafeTestDataUtility.getCybercafe();
		EasyMock.expect(userService.getUserByEmail(CybercafeTestDataUtility.EMAIL_ADDRESS))
				.andReturn(CybercafeTestDataUtility.getUser());
		EasyMock.replay(userService);
		cybercafeService.register(cybercafe);
		
	}
	
	

	
}
