package kh.com.kshrd.ams.repositories;

import java.sql.SQLException;
import java.util.List;

import kh.com.kshrd.ams.filtering.ArticleFilter;
import kh.com.kshrd.ams.models.Article;

public interface ArticleRepository {

	//TODO: TO SAVE THE ARTICLE
	public boolean save(Article article) throws SQLException;
	
	//TODO: TO UPDATE ARTICLE BY ID
	public boolean updateArticle(Article article) throws SQLException;
	
	//TODO: TO DELETE ARTICLE BY ID
	public boolean deleteArticle(Long id) throws SQLException;
	
	//TODO: TO FIND ALL ARTICLES WITH FILTERING AND PAGINATION
	public List<Article> findAllArticles(ArticleFilter fitler) throws SQLException;
	
	//TODO: TO FIND A ARTICLE BY ID
	public Article findArticleById(Long id) throws SQLException;
	
}
