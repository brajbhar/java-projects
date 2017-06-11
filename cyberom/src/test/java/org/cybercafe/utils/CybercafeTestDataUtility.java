package org.cybercafe.utils;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.cybercafe.model.Address;
import org.cybercafe.model.City;
import org.cybercafe.model.Cybercafe;
import org.cybercafe.model.IDCardType;
import org.cybercafe.model.Session;
import org.cybercafe.model.SessionStatus;
import org.cybercafe.model.State;
import org.cybercafe.model.Status;
import org.cybercafe.model.System;
import org.cybercafe.model.SystemUsage;
import org.cybercafe.model.User;
import org.cybercafe.model.Visitor;
import org.junit.Assert;

public class CybercafeTestDataUtility {
	
	
	public static final String EMAIL_ADDRESS = "bablu.rajbhar87@gmail.com";
	public static final String USER_NAME = "bablur";

	public static void assertCybercafe(Cybercafe expectedCybercafe,
			Cybercafe actualCybercafe) {
		Assert.assertNotNull("Fetched Cybercafe Object is Null",actualCybercafe);
		Assert.assertTrue("Cybercafe name not matching",actualCybercafe.getName()
				.equals(expectedCybercafe.getName()));
		Assert.assertTrue("Cybercafe phone number not matching",
				actualCybercafe.getPhoneNo()
				.equals(expectedCybercafe.getPhoneNo()));
		assertAddress(expectedCybercafe, actualCybercafe);
		assertUser(expectedCybercafe.getUser(), actualCybercafe.getUser());
		Assert.assertTrue("Updated on is not matching", actualCybercafe.getUpdatedOn()
				.equals(expectedCybercafe.getUpdatedOn()));
		Assert.assertNotNull(actualCybercafe.getStatus());
		Assert.assertTrue(actualCybercafe.getStatus().getName()
				.equals(expectedCybercafe.getStatus().getName()));
	}
	
	public static void assertComputer(System expected, System actual) {
		Assert.assertNotNull("actual comouter Object is null", actual);
		Assert.assertTrue("computer name not matching", 
				actual.getName().equals(expected.getName()));
		Assert.assertTrue("computer serial number not matching", 
				actual.getSerial().equals(expected.getSerial()));
		Assert.assertTrue("status not matching", actual.getStatus().equals(expected.getStatus()));
		Assert.assertTrue("updated by not matching", 
				actual.getUpdatedBy().equals(expected.getUpdatedBy()));
		Assert.assertTrue("cybercafe not matching", actual.getCybercafe().equals(expected.getCybercafe()));
		
	}

	public static void assertUser(User expected, User actual) {
		Assert.assertNotNull("Fetched cybercafe's user is NULL ", actual);
		Assert.assertTrue("Fetched cybercafe's username is not matching", 
				expected.getUserName().equals(actual.getUserName()));
		
		Assert.assertEquals("Fetched cybercafe's email is not matching", 
				expected.getEmail(), actual.getEmail());
		
		Assert.assertEquals("Fetched cybercafe's firstname is not matching", 
				expected.getFirstName(), actual.getFirstName());
		
		Assert.assertEquals("Fetched cybercafe's lastname is not matching", 
				expected.getLastName(), actual.getLastName());
		
		Assert.assertEquals("Fetched cybercafe's encrypted password is not matching", 
				"ac7938d40cfc2307e2bf325d28e7884e", actual.getPassword());
		
	}

	public static void assertAddress(Cybercafe cybercafe,
			Cybercafe fetchedCybercafe) {
		Assert.assertNotNull("Address of cybercafe is NULL",
				fetchedCybercafe.getAddress());
		Assert.assertTrue("Address line 1 is not matching", fetchedCybercafe.getAddress().getAddressLine1()
				.equals(cybercafe.getAddress().getAddressLine1()));
		Assert.assertTrue("Address line 2 is not matching", fetchedCybercafe.getAddress().getAddressLine2()
				.equals(cybercafe.getAddress().getAddressLine2()));
		Assert.assertTrue("Address Pin is not matching", fetchedCybercafe.getAddress().getPin()
				.equals(cybercafe.getAddress().getPin()));
		Assert.assertNotNull("Address City is NULL", 
				fetchedCybercafe.getAddress().getCity());
		Assert.assertNotNull("City's State object is Null", 
				fetchedCybercafe.getAddress().getCity());
	}

	public static Cybercafe getCybercafe() {
		Cybercafe cybercafe = new Cybercafe("Siddhivinayak", 
				"25746596", getAddress(), new Date(), getInActiveStatus(), getUser());
		return cybercafe;
	}

	public static User getUser() {
		User user = new User();
		user.setUserName("bablur");
		user.setFirstName("Bablu");
		user.setLastName("Rajbhar");
		user.setEmail(EMAIL_ADDRESS);
		user.setPassword("plain");
		user.setUpdatedOn(new Date());
		user.setRandomUUID(UUID.randomUUID().toString());
		user.setStatus(getInActiveStatus());
		return user;
	}

	public static Status getInActiveStatus() {
		Status status = new Status();
		status.setName("Inactive");
		status.setId(2L);
		return status;
	}


	public static Address getAddress() {
		Address address = new Address("Room no3", 
				"Bandukwala chawl vikhroli village", "400078", getCity());
		return address;
	}

	public static City getCity() {
		City city = new City(2L,"Mumbai", new State(2L,"Maharashtra"));
		return city;
	}

	public static Status getActiveStatus() {
		Status status = new Status();
		status.setName("active");
		return status;
	}

	public static Visitor getVisitor(Cybercafe cybercafe, IDCardType idCardType, User user) {
		Visitor visitor = new Visitor();
		visitor.setFirstName("Jhon");
		visitor.setLastName("Cena");
		visitor.setAge(26);
		visitor.setMobile("9819034283");
		visitor.setSex("Male");
		visitor.setAddress(getAddress());
		visitor.setCybercafe(cybercafe);
		visitor.setIdCardNumber("testnumber");
		visitor.setIdCardType(idCardType);
		visitor.setUpdatedBy(user);
		visitor.setUpdatedOn(new Date());
		
		return visitor;
	}
	
	public static IDCardType getIDCardType(){
		IDCardType type = new IDCardType();
		type.setId(1L);
		type.setName("Aadhar");
		return type;
	}
	
	public static System getComputer(Cybercafe cybercafe, Status status, User user) {
		System computer = new System();
		computer.setCybercafe(cybercafe);
		computer.setName("computer1");
		computer.setSerial("12345");
		computer.setStatus(status);
		computer.setUpdatedBy(user);
		computer.setUpdatedOn(new Date());
		return computer;
	}
	
	public static Session getSession(Cybercafe cybercafe, Visitor visitor, 
			User user, System system, SessionStatus sessionStatus 
			 ) {
		Session session = new Session();
		session.setVisitor(visitor);
		session.setCreatedOn(new Date());
		session.setCybercafe(cybercafe);
		session.setUpdatedBy(user);
		session.setSessionStatus(sessionStatus);
		session.setUpdatedOn(new Date());
		session.setStartTime(new Date());
		if(system != null) {
			Set<SystemUsage> systemUsages = new HashSet<>();
			SystemUsage systemUsage = new SystemUsage();
			systemUsage.setSystem(system);
			systemUsage.setStartTime(session.getStartTime());
			systemUsages.add(systemUsage);
			session.setSystemUsages(systemUsages);
		}
		return session;
	}

}