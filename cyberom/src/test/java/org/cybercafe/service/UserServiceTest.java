/**
 * 
 */
package org.cybercafe.service;

import java.util.UUID;

import org.cybercafe.AbstractRepositoryTest;
import org.cybercafe.AbstractTest;
import org.cybercafe.constant.CybercafeConstants;
import org.cybercafe.exception.RandomUUIDNotFoundException;
import org.cybercafe.model.User;
import org.cybercafe.repository.StatusRepository;
import org.cybercafe.repository.UserRepository;
import org.cybercafe.repository.UserRepositoryTest;
import org.cybercafe.utils.CybercafeTestDataUtility;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Bablu Rajbhar
 *
 */
public class UserServiceTest extends AbstractTest {
	
	private static final String ACTIVE = "active";

	private static final String VALID_RANDOM_UUID = UUID.randomUUID().toString();
	
	@Autowired
	UserService userService;
	
	UserRepository userRepository;
	
	StatusRepository statusRepository;
	
	User user = CybercafeTestDataUtility.getUser();
	
	@Before
	public void before() {
		userRepository = EasyMock.createMock(UserRepository.class);
		statusRepository = EasyMock.createMock(StatusRepository.class);
		buildUserServiceByMockObjects();
	}

	
	@Test
	public void testActivateUserWithValidRandomUUID() throws RandomUUIDNotFoundException {
		
		EasyMock.expect(userRepository.findOneByRandomUUID(VALID_RANDOM_UUID))
			.andReturn(user);
		EasyMock.expect(statusRepository.findOneByName(ACTIVE))
			.andReturn(CybercafeTestDataUtility.getActiveStatus());
		EasyMock.expect(userRepository.save(user))
			.andReturn(getUserWithActiveStatus(user));
		EasyMock.replay(userRepository);
		EasyMock.replay(statusRepository);
		User actualUser = userService.activateUser(VALID_RANDOM_UUID);
		Assert.assertNotNull(actualUser);
		Assert.assertEquals(ACTIVE, actualUser.getStatus().getName());
	}
	
	@Test(expected = RandomUUIDNotFoundException.class)
	public void testActivateUserWithInvalidRandomUUID() throws RandomUUIDNotFoundException {
		EasyMock.expect(userRepository.findOneByRandomUUID(CybercafeConstants.INVALID_RANDOM_UUID))
			.andReturn(null);
		EasyMock.replay(userRepository);
		User actualUser = userService.activateUser(CybercafeConstants.INVALID_RANDOM_UUID);
	}
	
	@Test
	public void testGetUserByUserName() {
		EasyMock.expect(userRepository.findOneByUserName(UserRepositoryTest.USER_NAME))
										.andReturn(user);
		EasyMock.replay(userRepository);
		User user = userService.getUserByUserName(UserRepositoryTest.USER_NAME);
		Assert.assertNotNull(user);
		Assert.assertNotNull(user.getUserName());
		Assert.assertTrue(user.getUserName().equals(UserRepositoryTest.USER_NAME));
	}
	
	@Test
	public void testGetUserByEmail() {
		EasyMock.expect(userRepository.findOneByEmail(UserRepositoryTest.EMAIL_ADDRESS))
										.andReturn(user);
		EasyMock.replay(userRepository);
		User user = userService.getUserByEmail(UserRepositoryTest.EMAIL_ADDRESS);
		Assert.assertNotNull(user);
		Assert.assertNotNull(user.getEmail());
		Assert.assertTrue(user.getEmail().equals(UserRepositoryTest.EMAIL_ADDRESS));
	}
	
	
	private void buildUserServiceByMockObjects() {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		userServiceImpl.setUserRepository(userRepository);
		userServiceImpl.setStatusRepository(statusRepository);
		userService = userServiceImpl;
	}
	
	private User getUserWithActiveStatus(User user) {
		user.setStatus(CybercafeTestDataUtility.getActiveStatus());
		return user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}
