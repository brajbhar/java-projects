package org.cybercafe.service;

import org.cybercafe.constant.CybercafeConstants;
import org.cybercafe.exception.RandomUUIDNotFoundException;
import org.cybercafe.model.Status;
import org.cybercafe.model.User;
import org.cybercafe.repository.StatusRepository;
import org.cybercafe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	StatusRepository statusRepository;

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User activateUser(String randomUUID) throws RandomUUIDNotFoundException {
		User user = userRepository.findOneByRandomUUID(randomUUID);
		if(user != null) {
			user = activateUserStatus(user);
		}
		else {
			throw new RandomUUIDNotFoundException("No user found with randomUUID :"+randomUUID);
		}
		return user;
	}
	
	@Override
	public User getUserByUserName(String userName) {
		return userRepository.findOneByUserName(userName);
	}
	
	@Override
	public User getUserByEmail(String email) {
		return userRepository.findOneByEmail(email);
	}
	


	private User activateUserStatus(User user) {
		user.setStatus(getActiveStatus());
		return userRepository.save(user);
	}


	private Status getActiveStatus() {
		return statusRepository.findOneByName(CybercafeConstants.ACTIVE);
	}
	

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public StatusRepository getStatusRepository() {
		return statusRepository;
	}

	public void setStatusRepository(StatusRepository statusRepository) {
		this.statusRepository = statusRepository;
	}

}
