/**
 * 
 */
package com.publisher.admin.dao;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.publisher.admin.domain.Category;

/**
 * @author brajbhar
 *
 */
@Repository
public class CategoryDaoImpl extends BaseDaoImpl implements CategoryDao {

	public static final Logger LOGGER = Logger.getLogger(CategoryDaoImpl.class);
	
	
	/* (non-Javadoc)
	 * @see com.publisher.admin.dao.CategoryDao#findCategoryById(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	public Category findCategoryById(Integer categoryId) {

		LOGGER.info("CategoryDaoImpl- findCategoryById() Starts");
		Session session = getCurrentSession();
		Category category = null;
		String query = "from Category c where c.id=:categoryId";
		List<Category> categories = (List<Category>)session.createQuery(query).setInteger("categoryId", categoryId).list();
		if(categories!=null && categories.size()>0){
			category = categories.get(0);
		}
		LOGGER.info("CategoryDaoImpl- findCategoryById() ends");
		return category;
	}

	/* (non-Javadoc)
	 * @see com.publisher.admin.dao.CategoryDao#getCategories()
	 */
	@SuppressWarnings("unchecked")
	public List<Category> getCategories() {
		LOGGER.info("CategoryDaoImpl- getCategories() Starts");
		Session session = getCurrentSession();
		String queryString = "select c.id, c.name, c.description from Category c where c.parent is null";
		Query query = session.createQuery(queryString); 
		List<Category> categories = query.list();
		LOGGER.info("CategoryDaoImpl- getCategories() Ends");
		return categories;
	}

	/* (non-Javadoc)
	 * @see com.publisher.admin.dao.CategoryDao#getCategories(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getSubCategories(Integer categoryId) {
		LOGGER.info("CategoryDaoImpl- getSubCategories(Integer categoryId)");
		Session session = getCurrentSession();
		String queryString = "select c.id, c.name, c.description from Category c"+
				" where c.parentCategoryId=:categoryId";
		Query query = session.createQuery(queryString);
		query.setInteger("categoryId", categoryId);
		List<Category> subCategories = query.list();
		LOGGER.info("CategoryDaoImpl- getSubCategories(Integer categoryId)");
		return subCategories;
	}
	

}
