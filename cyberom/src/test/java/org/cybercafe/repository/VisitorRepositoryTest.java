/**
 * 
 */
package org.cybercafe.repository;



import java.util.List;

import org.cybercafe.AbstractRepositoryTest;
import org.cybercafe.model.Cybercafe;
import org.cybercafe.model.IDCardType;
import org.cybercafe.model.Visitor;
import org.cybercafe.utils.CybercafeTestDataUtility;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @author Bablu Rajbhar
 *	Test data is populated by using data.sql
 */
public class VisitorRepositoryTest extends AbstractRepositoryTest {
	
	@Autowired
	private VisitorRepository visitorRepository;
	
	@Autowired
	private CybercafeRepository cybercafeRepository;
	
	@Autowired
	private IDCardTypeRepository idCardTypeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void testSave() {
		
		Visitor visitor = visitorRepository.save(CybercafeTestDataUtility
				.getVisitor(cybercafeRepository.findOne(1L), 
						idCardTypeRepository.findOne(1L), userRepository.findOne(1L)));
		Assert.assertNotNull(visitor);
		Assert.assertNotNull(visitor.getCybercafe());
		
	}
	
	@Test
	public void testFindAllWithPaging() {
		int pageNumber = 0;
		int pageSize = 5;
		Visitor visitor = new Visitor();
		visitor.setMobile("9819034283");
		visitor.setCybercafe(cybercafeRepository.findOne(1L));
		VisitorSpecification specification  = new VisitorSpecification(visitor);
		
		Page<Visitor> visitors = visitorRepository.findAll(specification, new PageRequest(pageNumber, pageSize));
		Assert.assertNotNull(visitors);
		Assert.assertTrue(visitors.getContent().size() <= pageSize);
		Assert.assertEquals(visitors.getNumber(), pageNumber);
		Assert.assertEquals(visitors.getNumberOfElements(), pageSize);
		
		for(Visitor visitorObj : visitors.getContent()) {
			Assert.assertEquals(visitorObj.getMobile(), visitor.getMobile());
			Assert.assertEquals(visitorObj.getCybercafe(), visitor.getCybercafe());
		}
	}
	
	@Test
	public void testFindByFirstNameAndLastName() {
		Visitor visitor = visitorRepository.save(CybercafeTestDataUtility.getVisitor(cybercafeRepository.findOne(1L), 
				idCardTypeRepository.findOne(1L), userRepository.findOne(1L)));
		Assert.assertNotNull(visitor);
		String firstName = visitor.getFirstName();
		String lastName = visitor.getLastName();
		visitor = visitorRepository.findByFirstNameAndLastName(visitor.getFirstName(), visitor.getLastName());
		Assert.assertNotNull(visitor);
		Assert.assertEquals(visitor.getFirstName(), firstName);
		Assert.assertEquals(visitor.getLastName(), lastName);
	}
	
	@Test
	public void testFindByFirstNameAndLastNameAndMobile() {
		Visitor visitor = visitorRepository.save(CybercafeTestDataUtility.getVisitor(cybercafeRepository.findOne(1L), 
				idCardTypeRepository.findOne(1L), userRepository.findOne(1L)));
		Assert.assertNotNull(visitor);
		String firstName = visitor.getFirstName();
		String lastName = visitor.getLastName();
		String mobile = visitor.getMobile();
		visitor = visitorRepository.findByFirstNameAndLastNameAndMobileAndCybercafe(visitor.getFirstName(), 
				visitor.getLastName(), visitor.getMobile(), visitor.getCybercafe());
		Assert.assertNotNull(visitor);
		Assert.assertEquals(visitor.getFirstName(), firstName);
		Assert.assertEquals(visitor.getLastName(), lastName);
		Assert.assertEquals(visitor.getMobile(), mobile);
	}
	
	@Test
	public void testFindByIdCardTypeAndIdNumber() {
		Visitor visitor = visitorRepository.save(CybercafeTestDataUtility.getVisitor(cybercafeRepository.findOne(1L), 
				idCardTypeRepository.findOne(1L), userRepository.findOne(1L)));
		Assert.assertNotNull(visitor);
		IDCardType idCardType = visitor.getIdCardType();
		String idCardNumnber = visitor.getIdCardNumber();
		visitor = visitorRepository.findByIdCardNumberAndIdCardTypeAndCybercafe(idCardNumnber, idCardType, visitor.getCybercafe());
		Assert.assertNotNull(visitor);
		Assert.assertEquals(visitor.getIdCardNumber(), idCardNumnber);
		Assert.assertEquals(visitor.getIdCardType(), idCardType);
		
	}
	
	@Test
	public void testGetFindOne() {
		 
	}
	
}
