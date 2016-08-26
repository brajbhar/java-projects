package org.cybercafe.service;

import java.util.List;

import org.cybercafe.model.City;

public interface CityService {
	List<City> getCitiesByStateId(Long id);

}
