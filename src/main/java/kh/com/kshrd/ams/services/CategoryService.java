package kh.com.kshrd.ams.services;

import java.util.List;

import kh.com.kshrd.ams.exceptions.BusinessException;
import kh.com.kshrd.ams.filtering.CategoryFilter;
import kh.com.kshrd.ams.models.Category;

public interface CategoryService {

	//TODO: TO ADD NEW CATEGORY SERVICE
	public boolean addNewCategory(Category category) throws BusinessException;
	
	//TODO: TO UPDATE CATEGORY BY ID SERVICE
	public boolean updateCategory(Category category) throws BusinessException;
	
	//TODO: TO DELETE CATEGORY SERVICE
	public boolean deleteCategory(Long id) throws BusinessException;
	
	//TODO: TO GET ALL CATEGORY SERVICE
	public List<Category> findAllCategories(CategoryFilter filter) throws BusinessException;
	
	//TODO: TO GET A CATEGORY BY ID SERVICE
	public Category findCategoryById(Long id) throws BusinessException;
}
