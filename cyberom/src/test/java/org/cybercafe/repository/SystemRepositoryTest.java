/**
 * 
 */
package org.cybercafe.repository;

import org.cybercafe.AbstractRepositoryTest;
import org.cybercafe.domain.SystemSearchFilter;
import org.cybercafe.model.System;
import org.cybercafe.utils.CybercafeTestDataUtility;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @author Bablu
 *
 */
public class SystemRepositoryTest extends AbstractRepositoryTest {

	@Autowired
	private SystemRepository computerRepository;
	
	@Autowired
	private CybercafeRepository cybercafeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	
	@Test
	public void testSave() {
		System computer = CybercafeTestDataUtility.getComputer(
				cybercafeRepository.findOne(1L), statusRepository.findOne(1L), 
				userRepository.findOne(1L));
		System computerSaved = computerRepository.save(computer);
		CybercafeTestDataUtility.assertComputer(computer, computerSaved);
		
	}
	
	@Test
	public void testFindAllWithPaging() {
		int pageNumber = 0;
		int pageSize = 5;
		
		SystemSearchFilter filter = new SystemSearchFilter();
		SystemSpecification specification = new SystemSpecification(filter);
		
		Page<System> computers = computerRepository.findAll(specification, new PageRequest(pageNumber, pageSize));
		Assert.assertNotNull(computers);
		Assert.assertTrue(computers.getContent().size() == pageSize);
		
	}
}
