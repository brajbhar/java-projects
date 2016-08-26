package org.cybercafe.repository;

import org.cybercafe.AbstractRepositoryTest;
import org.cybercafe.constant.CybercafeConstants;
import org.cybercafe.model.User;
import org.cybercafe.utils.CybercafeTestDataUtility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest extends AbstractRepositoryTest {
	

	public static final String EMAIL_ADDRESS = "bablu.rajbhar87@gmail.com";

	public static final String USER_NAME = "bablur";

	@Autowired
	UserRepository userRepository;
	
	User expectedUser;
	
	@Test
	public void testFindOneByRandomUUID() {
		expectedUser = CybercafeTestDataUtility.getUser();
		userRepository.save(expectedUser);
		User actualUser = userRepository.findOneByRandomUUID(expectedUser.getRandomUUID());
		Assert.assertNotNull(actualUser);
		Assert.assertEquals(expectedUser.getRandomUUID(), actualUser.getRandomUUID());
		
	}
	
	@Test
	public void testFindOneByRandomUUIDForInvalidRandomUUID() {
		User actualUser = userRepository.findOneByRandomUUID(CybercafeConstants.INVALID_RANDOM_UUID);
		Assert.assertNull(actualUser);
	}
	
	@Test
	public void testFindByUsername() {
		User user = userRepository.findOneByUserName(USER_NAME);
		Assert.assertNotNull(user);
		Assert.assertNotNull(user.getUserName());
		Assert.assertTrue(user.getUserName().equals(USER_NAME));
	}
	
	@Test 
	public void testFindByEmail() {
		User user = userRepository.findOneByEmail(EMAIL_ADDRESS);
		Assert.assertNotNull(user);
		Assert.assertNotNull(user.getEmail());
		Assert.assertTrue(user.getEmail().equals(EMAIL_ADDRESS));
	}
}
