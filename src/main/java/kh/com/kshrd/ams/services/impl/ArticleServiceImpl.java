package kh.com.kshrd.ams.services.impl;

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
	public Article addNewArticle(Article article) {
		try {
			return articleRepository.save(article);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Article updateArticle(Article article){
		try {
			return articleRepository.update(article);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Article deleteArticle(Long id) {
		try {
			return articleRepository.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Article> findAllArticles(ArticleFilter filter, Pagination pagination) {
		try {
			return articleRepository.findAll(filter, pagination);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Article findArticleById(Long id) {
		try {
			return articleRepository.findOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Article> findAllArticlesByCategoryId(Long categoryId, Pagination pagination) {
		try {
			return articleRepository.findAllByCategoryId(categoryId, pagination);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
