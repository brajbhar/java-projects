/**
 * 
 */
package com.publisher.admin.contoller;

import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.publisher.admin.domain.Category;
import com.publisher.admin.service.CategoryService;

/**
 * @author brajbhar
 *
 */
@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/getCategoryDetails.html")
	public ModelAndView getCategoryDetails(){
		
		
		System.out.println("Inside controller");
		ModelAndView mav = new ModelAndView();
		/*Category category = categoryService.findCategoryById(6);
		System.out.println("Catgory Id : "+category.getId());
		System.out.println("Parent Id : "+category.getParent().getId());
		Set<Category> subCategories = category.getSubCategories();
		Iterator<Category> itr = subCategories.iterator();
		System.out.println("SubCategories");
		while(itr.hasNext()){
			//System.out.println(itr.next().getName());
			System.out.println("Length of subcategory "+itr.next().getSubCategories().size());
		}
		
		Category category = new Category();
		category.setId(10);
		category.setName("Music");
		category.setDescription("Cassates of music albums");
		boolean flag = categoryService.save(category);
		if(flag){
			System.out.println("Saved");
		}*/
		mav.setViewName("category");
		return mav;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	
	
}
