package org.cybercafe.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class VisitorControllerTest extends BaseControllerTest {
	
	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testGetVisitors() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/rest/visitors").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

}
