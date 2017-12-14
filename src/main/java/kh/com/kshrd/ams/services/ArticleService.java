package kh.com.kshrd.ams.services;

import java.util.List;

import kh.com.kshrd.ams.filtering.ArticleFilter;
import kh.com.kshrd.ams.models.Article;
import kh.com.kshrd.ams.utilities.Pagination;

public interface ArticleService {

	//TODO: TO ADD NEW ARTICLE SERVICE
	public Article addNewArticle(Article article);
	
	//TODO: TO UPDATE ARTICLE SERVICE
	public Article updateArticle(Article article);
	
	//TODO: TO DELETE ARTICLE SERVICE
	public Article deleteArticle(Long id);
	
	//TODO: TO GET ALL ARTICLES SERVICE
	public List<Article> findAllArticles(ArticleFilter filter, Pagination pagination);
	
	//TODO: TO GET A ARTICLE BY ID
	public Article findArticleById(Long id);
	
	public List<Article> findAllArticlesByCategoryId(Long categoryId, Pagination pagination);
}
