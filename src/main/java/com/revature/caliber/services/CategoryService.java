package com.revature.caliber.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.Category;
import com.revature.caliber.exceptions.DoesNotExistException;
import com.revature.caliber.converter.CategoryConverter;
import com.revature.caliber.dto.CategoryDTO;
import com.revature.caliber.exceptions.DuplicateException;
import com.revature.caliber.repositories.CategoryRepository;

@Service
public class CategoryService implements CategoryServiceInterface{

	Logger log = Logger.getLogger("CategoryService.class"); 
	
	@Autowired
	private CategoryRepository categoryRepository;
	

	public Category createCategory(CategoryDTO categoryDTO) {
		Category category = CategoryConverter.convert(categoryDTO);
		Category categoryObj = categoryRepository.findBySkillCategory(category.getSkillCategory());
		if (categoryObj != null)
			throw new DuplicateException("Skill category already exists");
		else 
			return categoryRepository.save(category);
	}

	public Category updateCategory(CategoryDTO categoryDTO) {
		Category category = CategoryConverter.convert(categoryDTO);
		Category categoryObj = categoryRepository.findByCategoryId(category.getCategoryId());
		if(categoryObj == null) {
			throw new DoesNotExistException("Category does not already exist");
		}
		else {
			return categoryRepository.save(category);
		}
	}
	
	public List<Category> listAllCategories(){
		List <Category> cList = categoryRepository.findAll();
		if(cList == null) {
			throw new DoesNotExistException("No categories exist");
		}
		else {
			return cList;
		}
	}
}
