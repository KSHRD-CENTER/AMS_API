package kh.com.kshrd.ams.services.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.kshrd.ams.exceptions.BusinessException;
import kh.com.kshrd.ams.filtering.ArticleFilter;
import kh.com.kshrd.ams.models.Article;
import kh.com.kshrd.ams.repositories.ArticleRepository;
import kh.com.kshrd.ams.services.ArticleService;
import kh.com.kshrd.ams.utilities.Pagination;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleRepository articleRepository;
	
	@Override
	public boolean addNewArticle(Article article) throws BusinessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateArticle(Article article) throws BusinessException {
		return false;
	}

	@Override
	public boolean deleteArticle(Long id) throws BusinessException {
		return false;
	}

	@Override
	public List<Article> findAllArticles(ArticleFilter filter, Pagination pagination) throws BusinessException {
		try {
			return articleRepository.findAllArticles(filter, pagination);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException();
		}
	}

	@Override
	public Article findArticleById(Long id) throws BusinessException {
		try {
			return articleRepository.findArticleById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException();
		}
	}

}
