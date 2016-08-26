/**
 * 
 */
package org.cybercafe.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author Bablu Rajbhar
 *
 */

public class CybercafeControllerTest extends BaseControllerTest {
	
	@Before
	public void before() {
		mvc = MockMvcBuilders.standaloneSetup(new CybercafeController()).build();
	}
	
	@Test
	public void testRegisterCybercafe() throws Exception{
		/*mvc.perform(MockMvcRequestBuilders.post("/registerCybercafe")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());*/
	}
}
