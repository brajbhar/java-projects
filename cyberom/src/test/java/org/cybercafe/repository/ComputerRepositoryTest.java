/**
 * 
 */
package org.cybercafe.repository;

import org.cybercafe.AbstractRepositoryTest;
import org.cybercafe.model.Computer;
import org.cybercafe.utils.CybercafeTestDataUtility;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Bablu
 *
 */
public class ComputerRepositoryTest extends AbstractRepositoryTest {

	@Autowired
	private ComputerRepository computerRepository;
	
	@Autowired
	private CybercafeRepository cybercafeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	
	@Test
	public void testSave() {
		Computer computer = CybercafeTestDataUtility.getComputer(
				cybercafeRepository.findOne(1L), statusRepository.findOne(1L), 
				userRepository.findOne(1L));
		Computer computerSaved = computerRepository.save(computer);
		CybercafeTestDataUtility.assertComputer(computer, computerSaved);
		
	}
	
	@Test
	public void testFindAllWithPaging() {
		int pageNumber = 0;
		int pageSize = 5;
		
		
	}
}