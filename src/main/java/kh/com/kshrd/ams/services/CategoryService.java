package kh.com.kshrd.ams.services;

import java.util.List;

import kh.com.kshrd.ams.exceptions.BusinessException;
import kh.com.kshrd.ams.filtering.CategoryFilter;
import kh.com.kshrd.ams.models.Article;
import kh.com.kshrd.ams.models.Category;

public interface CategoryService {

	//TODO: TO ADD NEW CATEGORY SERVICE
	public boolean addNewArticle(Article article) throws BusinessException;
	
	//TODO: TO UPDATE CATEGORY BY ID SERVICE
	public boolean updateArticle(Article article) throws BusinessException;
	
	//TODO: TO DELETE CATEGORY SERVICE
	public boolean deleteArticle(Long id) throws BusinessException;
	
	//TODO: TO GET ALL CATEGORY SERVICE
	public List<Category> findAllCategories(CategoryFilter filter) throws BusinessException;
}