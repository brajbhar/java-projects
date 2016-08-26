package org.cybercafe.service;

import java.util.ArrayList;
import java.util.List;

import org.cybercafe.model.State;
import org.cybercafe.repository.StateRepository;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class StateServiceTest {
	
	@Autowired
	private StateService stateService;
	
	private StateRepository stateRepository;
	
	@Before
	public void before() {
		stateRepository = EasyMock.createMock(StateRepository.class);
		StateServiceImpl stateServiceImpl = new StateServiceImpl();
		stateServiceImpl.setStateRepository(stateRepository);
		stateService = stateServiceImpl;
	}
	
	@Test
	public void testGetStates() {
		EasyMock.expect(stateRepository.findAll()).andReturn(getMockStates());
		EasyMock.replay(stateRepository);
		List<State> states = stateService.getStates();
		Assert.assertNotNull(states);
		boolean foundState = false;
		for(State state: states) {
			if(state.getName().equals("Maharashtra")) {
				foundState = true;
			}
		}
		
		Assert.assertTrue(foundState);
		
	}

	private List<State> getMockStates() {
		List<State> states =  new ArrayList<State>();
		states.add(new State(1L,"Punjab"));
		states.add(new State(2L,"Maharashtra"));
		states.add(new State(3L,"Gujarat"));
		states.add(new State(4L,"Madhya Pradesh"));
		states.add(new State(5L,"Rajasthan"));
		return states;
		
	}

	public StateService getStateService() {
		return stateService;
	}

	public void setStateService(StateService stateService) {
		this.stateService = stateService;
	}

	
	
	

}
