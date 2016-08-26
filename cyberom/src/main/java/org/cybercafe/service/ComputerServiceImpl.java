/**
 * 
 */
package org.cybercafe.service;

import org.cybercafe.model.Computer;
import org.cybercafe.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Bablu
 *
 */
@Service
public class ComputerServiceImpl implements ComputerService {
	
	@Autowired
	ComputerRepository computerRepository;
	
	@Override
	public Computer addComputer(Computer computer) {
		return computerRepository.save(computer);
	}

}
