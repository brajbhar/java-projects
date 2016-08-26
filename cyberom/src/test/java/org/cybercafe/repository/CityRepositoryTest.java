package org.cybercafe.repository;

import java.util.List;

import org.cybercafe.AbstractRepositoryTest;
import org.cybercafe.model.City;
import org.cybercafe.model.State;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CityRepositoryTest extends AbstractRepositoryTest {
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Test
	public void testFindByState(){
		State state = stateRepository.findOne(2L);
		List<City> cities = cityRepository.findByStateId(2L);
		Assert.assertNotNull(cities);
		Assert.assertEquals(4, cities.size());
		
	}

}
