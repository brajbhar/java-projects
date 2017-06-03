/**
 * 
 */
package org.cybercafe.service;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.DuplicateFormatFlagsException;
import java.util.UUID;

import org.cybercafe.exception.DuplicateUserEmailException;
import org.cybercafe.exception.DuplicateUserNameException;
import org.cybercafe.model.Cybercafe;
import org.cybercafe.model.User;
import org.cybercafe.repository.CybercafeRepository;
import org.cybercafe.repository.StatusRepository;
import org.cybercafe.repository.UserRepository;
import org.cybercafe.utils.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Bablu Rajbhar
 *
 */
@Service
public class CybercafeServiceImpl implements CybercafeService {
	
	private static final String INACTIVE = "inactive";

	@Autowired
	CybercafeRepository cybercafeRepository;
	
	@Autowired
	EMailSenderService emailSenderService;
	
	@Autowired
	EMailGeneratorService emailGenerator;
	
	@Autowired
	StatusRepository statusRepository;
	
	@Autowired
	UserService userService;
	
	
	@Override
	public Cybercafe register(Cybercafe cybercafe) throws Exception {
		thowExceptionIfDuplicateEmailFound(cybercafe); 
		throwExceptionIfDuplicateUserNameFound(cybercafe);
		cybercafe.setUser(modifyUser(cybercafe.getUser()));
		modifyStatus(cybercafe);
		modifyUpdatedOn(cybercafe);
		cybercafe = cybercafeRepository.save(cybercafe);
		emailSenderService.sendAccountActivationEMail(cybercafe);
		return cybercafe;
	}
	
	@Override
	public Cybercafe getCybercafe(Long id) throws Exception {
		return cybercafeRepository.findOne(id);
	}


	private void throwExceptionIfDuplicateUserNameFound(Cybercafe cybercafe)
			throws DuplicateUserNameException {
		if(userService.getUserByUserName(cybercafe.getUser().getUserName())!=null) {
			throw new DuplicateUserNameException("User with same username already exists");
		}
	}


	private void thowExceptionIfDuplicateEmailFound(Cybercafe cybercafe)
			throws DuplicateUserEmailException {
		if(userService.getUserByEmail(cybercafe.getUser().getEmail())!=null) {
			throw new DuplicateUserEmailException("User with same email id already exists");
		}
	}


	private User modifyUser(User user) throws NoSuchAlgorithmException {
		user.setPassword(EncryptionUtils
				.encrypt(user.getPassword()));
		user.setRandomUUID(UUID.randomUUID().toString());
		return user;
	}


	private void modifyUpdatedOn(Cybercafe cybercafe) {
		cybercafe.setUpdatedOn(new Date());
		cybercafe.getUser().setUpdatedOn(new Date());
	}


	private void modifyStatus(Cybercafe cybercafe) {
		cybercafe.getUser().setStatus(statusRepository.findOneByName(INACTIVE));
		cybercafe.setStatus(statusRepository.findOneByName(INACTIVE));
	}


	public CybercafeRepository getCybercafeRepository() {
		return cybercafeRepository;
	}

	public void setCybercafeRepository(CybercafeRepository cybercafeRepository) {
		this.cybercafeRepository = cybercafeRepository;
	}


	public EMailSenderService getEmailService() {
		return emailSenderService;
	}


	public void setEmailService(EMailSenderService emailService) {
		this.emailSenderService = emailService;
	}


	public EMailGeneratorService getEmailGenerator() {
		return emailGenerator;
	}


	public void setEmailGenerator(EMailGeneratorService emailGenerator) {
		this.emailGenerator = emailGenerator;
	}


	public EMailSenderService getEmailSenderService() {
		return emailSenderService;
	}


	public void setEmailSenderService(EMailSenderService emailSenderService) {
		this.emailSenderService = emailSenderService;
	}


	public StatusRepository getStatusRepository() {
		return statusRepository;
	}


	public void setStatusRepository(StatusRepository statusRepository) {
		this.statusRepository = statusRepository;
	}


	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public Cybercafe getCybercafe(String username) {
		User user = userService.getUserByEmail(username);
		return cybercafeRepository.findOneByUser(user);
	}


}
