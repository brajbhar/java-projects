/**
 * 
 */
package org.cybercafe.service;

import org.cybercafe.exception.RandomUUIDNotFoundException;
import org.cybercafe.model.User;

/**
 * @author Bablu Rajbhar
 *
 */
public interface UserService {
	
	User activateUser(String randomUUID) throws RandomUUIDNotFoundException;
	
	User getUserByUserName(String userName);

	User getUserByEmail(String email);

}
