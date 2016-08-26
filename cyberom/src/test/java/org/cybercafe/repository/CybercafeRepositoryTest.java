package org.cybercafe.repository;

import org.cybercafe.AbstractRepositoryTest;
import org.cybercafe.model.Cybercafe;
import org.cybercafe.utils.CybercafeTestDataUtility;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CybercafeRepositoryTest extends AbstractRepositoryTest{

	@Autowired
	private CybercafeRepository cybercafeRepository;
	
	@Test
	public void testSave() {
		
		Cybercafe expectedCybercafe = CybercafeTestDataUtility.getCybercafe();
		expectedCybercafe.getUser().setPassword("ac7938d40cfc2307e2bf325d28e7884e");
		Cybercafe actualCybercafe = cybercafeRepository.save(expectedCybercafe);
		CybercafeTestDataUtility.assertCybercafe(expectedCybercafe, actualCybercafe);
		
	}
}
