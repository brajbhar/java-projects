/**
 * 
 */
package org.cybercafe.service;

import org.cybercafe.domain.ComputerSearchFilter;
import org.cybercafe.model.Computer;
import org.springframework.data.domain.Page;

/**
 * @author Bablu
 *
 */
public interface ComputerService {
	
	Computer addComputer(Computer computer);
	
	Page<Computer> getComputers(ComputerSearchFilter filter);

}
