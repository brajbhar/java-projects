package org.cybercafe.repository;

import java.util.List;

import org.cybercafe.model.City;
import org.cybercafe.model.State;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long>{
	
	List<City> findByStateId(Long id);
}
