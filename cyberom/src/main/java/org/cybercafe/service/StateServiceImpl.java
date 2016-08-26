package org.cybercafe.service;

import java.util.List;

import org.cybercafe.model.State;
import org.cybercafe.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateServiceImpl implements StateService{
	
	@Autowired
	private StateRepository stateRepository;

	@Override
	public List<State> getStates() {
		
		return stateRepository.findAll();
	}

	public StateRepository getStateRepository() {
		return stateRepository;
	}

	public void setStateRepository(StateRepository stateRepository) {
		this.stateRepository = stateRepository;
	}
	
	

}
