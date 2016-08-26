/**
 * 
 */
package org.cybercafe.repository;

import java.util.List;

import org.cybercafe.model.Computer;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Bablu
 *
 */
public interface ComputerRepository extends CrudRepository<Computer, Long>{
	
	Computer save(Computer computer);
	
	Computer findOne(Long id);
	
	List<Computer> findAll();

}
