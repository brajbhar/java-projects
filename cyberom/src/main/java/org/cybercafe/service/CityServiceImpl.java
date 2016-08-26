package org.cybercafe.service;

import java.util.List;

import org.cybercafe.model.City;
import org.cybercafe.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	CityRepository cityRepository;
	
	@Override
	public List<City> getCitiesByStateId(Long id) {
		return cityRepository.findByStateId(id);
	}
	

	public CityRepository getCityRepository() {
		return cityRepository;
	}

	public void setCityRepository(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	
	

}
