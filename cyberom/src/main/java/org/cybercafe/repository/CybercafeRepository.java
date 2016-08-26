/**
 * 
 */
package org.cybercafe.repository;

import java.util.List;

import org.cybercafe.model.Cybercafe;
import org.cybercafe.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Bablu Rajbhar
 *
 */
public interface CybercafeRepository extends CrudRepository<Cybercafe, Long>{
	List<Cybercafe> findByName(String name);
	Cybercafe findOneByUser(User user);
}
