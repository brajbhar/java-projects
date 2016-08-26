/**
 * 
 */
package org.cybercafe.service;

import org.cybercafe.AbstractTest;
import org.cybercafe.utils.CybercafeTestDataUtility;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Bablu Rajbhar
 *
 */
public class EMailSenderServiceTest extends AbstractTest {
	
	@Autowired
	EMailSenderService emailSenderService;
	
	
	@Test
	public void testSendAccountActivationEMail() {
		 emailSenderService.sendAccountActivationEMail(
				 CybercafeTestDataUtility.getCybercafe());
	}
}
