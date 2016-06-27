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
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public long addNewArticle(Article article) throws BusinessException {
		long id = 0;
		try {
			id = articleRepository.save(article);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException();
		}
		return id;
	}

	@Override
	public boolean updateArticle(Article article) throws BusinessException {
		try {
			return articleRepository.update(article);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException();
		}
	}

	@Override
	public boolean deleteArticle(Long id) throws BusinessException {
		try {
			return articleRepository.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException();
		}
	}

	@Override
	public List<Article> findAllArticles(ArticleFilter filter, Pagination pagination) throws BusinessException {
		try {
			return articleRepository.findAll(filter, pagination);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException();
		}
	}

	@Override
	public Article findArticleById(Long id) throws BusinessException {
		try {
			return articleRepository.findOne(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException();
		}
	}
}
