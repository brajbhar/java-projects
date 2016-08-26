/**
 * 
 */
package org.cybercafe.repository;

import org.cybercafe.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Bablu Rajbhar
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findOne(Long id);

	User findOneByRandomUUID(String randomUUID);
	
	User save(User user);

	User findOneByUserName(String username);

	User findOneByEmail(String email);
	
}
