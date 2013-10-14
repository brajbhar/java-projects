/**
 * 
 */
package com.publisher.admin.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Bablu Rajbhar
 *
 */
public class Category {
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String description;
	private Integer parentCategoryId;
	
	//One Category will have many sub categories (1:M)
	private Set<Category> subCategories = new HashSet<Category>();
	
	//Many child will have one parent (M:1)
	private Category parent;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category getParent() {
		return parent;
	}
	public void setParent(Category parent) {
		this.parent = parent;
	}
	public Set<Category> getSubCategories() {
		return subCategories;
	}
	public void setSubCategories(Set<Category> subCategories) {
		this.subCategories = subCategories;
	}
	
	public Integer getParentCategoryId() {
		return parentCategoryId;
	}
	public void setParentCategoryId(Integer parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	public String toString(){
		String str = "Category[id="+id+", name="+name+", description="+description+"]";
		return str;
	}

}
