/**
 * 
 */
package com.publisher.admin.dao;

import java.util.List;

import com.publisher.admin.domain.Category;

/**
 * @author brajbhar
 *
 */
public interface CategoryDao {
	
	Category findCategoryById(Integer categoryId);
	List<Category> getCategories();
	List<Category> getSubCategories(Integer categoryId);
	
}
