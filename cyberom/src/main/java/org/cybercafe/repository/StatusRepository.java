/**
 * 
 */
package org.cybercafe.repository;

import org.cybercafe.model.Status;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Bablu Rajbhar
 *
 */
public interface StatusRepository extends CrudRepository<Status, Long> {
	
	Status findOne(Long id);

	Status findOneByName(String string);

}
