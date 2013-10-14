/**
 * 
 */
package com.publisher.rest;

import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.publisher.admin.domain.Category;
import com.publisher.admin.service.CategoryService;
import com.publisher.common.WebConstants;

/**
 * @author Bablu Rajbhar
 *
 */
@Component
@Path(WebConstants.URL_REST_CONTROLLER)
public class RestController {
	
	
	private static final Logger LOGGER = Logger.getLogger(RestController.class);
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * @param categoryId
	 * @return mav
	 */
	@GET
	@Path(WebConstants.URL_REST_CONTROLLER_GET_CATEGORY)
	@Produces(MediaType.APPLICATION_JSON)
	public Category getCategory(@QueryParam("categoryId") int categoryId){
		LOGGER.info("RestController - getCategory() Starts");
		LOGGER.info("RestController - getCategory() ends");
		Category category = categoryService.findCategoryById(categoryId);
		
		/**
		 ******************** Make it JSON ready************************
		 ******************** Remove nesting of category**************** 
		 */
		if(category!=null && category.getSubCategories()!=null){
			
			Iterator<Category> itr = category.getSubCategories().iterator();
			while(itr.hasNext()){
				itr.next().setParent(null);
			}
		}
		
		
		return category;
	}
	
	/**
	 * @return categories
	 */
	@GET
	@Path(WebConstants.URL_REST_CONTROLLER_GET_CATEGORIES)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getCategories(){
		LOGGER.info("RestController - getCategories() Starts");
		LOGGER.info("RestController - getCategories() Ends");
		return categoryService.getCategories();
	}
	
	@GET
	@Path(WebConstants.URL_REST_CONTROLLER_GET_SUB_CATEGORIES)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getSubCategories(@QueryParam("categoryId") int categoryId){
		return categoryService.getSubCategories(categoryId);
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}



	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	
	
	
	

}
