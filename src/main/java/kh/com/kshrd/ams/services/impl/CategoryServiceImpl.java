package kh.com.kshrd.ams.services.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.kshrd.ams.exceptions.BusinessException;
import kh.com.kshrd.ams.filtering.CategoryFilter;
import kh.com.kshrd.ams.models.Article;
import kh.com.kshrd.ams.models.Category;
import kh.com.kshrd.ams.repositories.CategoryRepository;
import kh.com.kshrd.ams.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public boolean addNewArticle(Article article) throws BusinessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateArticle(Article article) throws BusinessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteArticle(Long id) throws BusinessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Category> findAllCategories(CategoryFilter filter) throws BusinessException {
		try {
			return categoryRepository.findAllCategories(filter);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException();
		}
	}

	@Override
	public Category findCategoryById(Long id) throws BusinessException {
		try{
			return categoryRepository.findCategoryById(id);
		}catch(SQLException e){
			e.printStackTrace();
			throw new BusinessException();
		}
	}

}
