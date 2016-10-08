/**
 * 
 */
package org.cybercafe.service;

import org.cybercafe.domain.ComputerSearchFilter;
import org.cybercafe.model.Computer;
import org.cybercafe.repository.ComputerRepository;
import org.cybercafe.repository.ComputerSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

	@Override
	public Page<Computer> getComputers(ComputerSearchFilter filter) {
		ComputerSpecification specification = new ComputerSpecification(filter);
		PageRequest pageRequest = new PageRequest(filter.getPageNumber(), filter.getPageSize());
		Page<Computer> computers = computerRepository.findAll(specification, pageRequest);
		return computers;
	}

}
