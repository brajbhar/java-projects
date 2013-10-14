/**
 * 
 */
package com.publisher.admin.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.publisher.admin.dao.CategoryDao;
import com.publisher.admin.domain.Category;

/**
 * @author brajbhar
 *
 */

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class CategoryServiceImpl implements CategoryService{
	
	public static final Logger LOGGER = Logger.getLogger(CategoryServiceImpl.class);
	
	@Autowired
	private CategoryDao categoryDao;
	
	
	/* (non-Javadoc)
	 * @see com.publisher.admin.service.CategoryService#findCategoryById(java.lang.Integer)
	 */
	public Category findCategoryById(Integer categoryId) {
		LOGGER.info("CategoryServiceImpl - findCategoryById() Starts");
		Category category = categoryDao.findCategoryById(categoryId);
		
		LOGGER.info("CategoryServiceImpl - findCategoryById() Ends");
		return category;
	}
	
	/* (non-Javadoc)
	 * @see com.publisher.admin.service.CategoryService#getCategories()
	 */
	public List<Category> getCategories() {
		
		return categoryDao.getCategories();
	}

	/* (non-Javadoc)
	 * @see com.publisher.admin.service.CategoryService#getSubCategories(java.lang.Integer)
	 */
	@Override
	public List<Category> getSubCategories(Integer categoryId) {
		
		return categoryDao.getSubCategories(categoryId);
	}
	
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	

}
