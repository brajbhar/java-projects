/**
 * 
 */
package org.cybercafe;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * To Populate the database with dummy data
 * @author Bablu Rajbhar
 *
 */
@Transactional
public abstract class AbstractRepositoryTest extends AbstractTest{
	
	@Autowired
	private DataSource dataSource;
	
	@Before
	public void before() {
		ResourceDatabasePopulator  populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("data.sql"));
		DatabasePopulatorUtils.execute(populator, dataSource);
	}
	
	
	
}
