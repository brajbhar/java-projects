package org.cybercafe.service;

import java.util.ArrayList;
import java.util.List;

import org.cybercafe.model.City;
import org.cybercafe.model.State;
import org.cybercafe.repository.CityRepository;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CityServiceTest {
	
	CityRepository mockCityRepository;
	
	CityService cityService;
	
	@Before
	public void before() {
		mockCityRepository = EasyMock.createMock(CityRepository.class);
		cityService =  getCityServiceWithMockedRepository();
	}

		
	@Test
	public void testGetCitiesWithStateId(){
		EasyMock.expect(mockCityRepository.findByStateId(2L)).andReturn(getCitiesOfMaharashtra());
		EasyMock.replay(mockCityRepository);
		Assert.assertEquals("",4, cityService.getCitiesByStateId(2L).size());
	}
	
	private List<City> getCitiesOfMaharashtra() {
		State state = new State(2L,"Maharashtra");
		List<City> cities = new ArrayList<City>();
		cities.add(new City(2L,"Mumbai", state));
		cities.add(new City(4L,"Nasik", state));
		cities.add(new City(3L,"Pune", state));
		cities.add(new City(5L,"Thane", state));
		return cities;
	}


	private CityServiceImpl getCityServiceWithMockedRepository() {
		CityServiceImpl cityServiceImpl = new CityServiceImpl();
		cityServiceImpl.setCityRepository(mockCityRepository);
		return cityServiceImpl;
	}
}
