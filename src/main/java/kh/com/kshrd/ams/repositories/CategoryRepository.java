package kh.com.kshrd.ams.repositories;

import java.sql.SQLException;
import java.util.List;

import kh.com.kshrd.ams.filtering.CategoryFilter;
import kh.com.kshrd.ams.models.Category;

public interface CategoryRepository {

	//TODO: TO FIND ALL CATEGORY WITH FILTERING AND PAGINATION
	public List<Category> findAllCategories(CategoryFilter fitler) throws SQLException;
	
	public Category findCategoryById(Long id) throws SQLException;
}
