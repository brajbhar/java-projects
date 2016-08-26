package org.cybercafe.repository;

import java.util.List;

import org.cybercafe.AbstractRepositoryTest;
import org.cybercafe.model.State;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class StateRepositoryTest extends AbstractRepositoryTest {
	
	@Autowired
	StateRepository stateRepository;
	
	@Test
	public void testFindAll() {
		List<State> states = stateRepository.findAll();
		Assert.assertNotNull("No state found", 
				states);
		Assert.assertTrue("Empty states list", 
				states.size()>0);
		
		Assert.assertTrue("Number of records found mismatch", 
				states.size() == 5);
	}

}
