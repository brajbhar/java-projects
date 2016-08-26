package org.cybercafe.repository;

import java.util.List;

import org.cybercafe.model.State;
import org.springframework.data.repository.CrudRepository;

public interface StateRepository extends CrudRepository<State, Long>{
	List<State> findAll();
}
