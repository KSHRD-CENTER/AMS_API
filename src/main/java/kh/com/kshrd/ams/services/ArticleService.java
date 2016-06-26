package kh.com.kshrd.ams.services;

import java.util.List;

import kh.com.kshrd.ams.exceptions.BusinessException;
import kh.com.kshrd.ams.filtering.ArticleFilter;
import kh.com.kshrd.ams.models.Article;
import kh.com.kshrd.ams.utilities.Pagination;

public interface ArticleService {

	//TODO: TO ADD NEW ARTICLE SERVICE
	public boolean addNewArticle(Article article) throws BusinessException;
	
	//TODO: TO UPDATE ARTICLE SERVICE
	public boolean updateArticle(Article article) throws BusinessException;
	
	//TODO: TO DELETE ARTICLE SERVICE
	public boolean deleteArticle(Long id) throws BusinessException;
	
	//TODO: TO GET ALL ARTICLES SERVICE
	public List<Article> findAllArticles(ArticleFilter filter, Pagination pagination) throws BusinessException;
	
	//TODO: TO GET A ARTICLE BY ID
	public Article findArticleById(Long id) throws BusinessException;
}
