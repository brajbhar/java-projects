/**
 * 
 */
package com.publisher.admin.service;

import java.util.Collection;
import java.util.List;

import com.publisher.admin.domain.Category;

/**
 * @author brajbhar
 *
 */
public interface CategoryService {
	Category findCategoryById(Integer categoryId);
	List<Category> getCategories();
	List<Category> getSubCategories(Integer categoryId);
}
