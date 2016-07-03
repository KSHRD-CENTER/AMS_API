package kh.com.kshrd.ams.repositories;

import java.sql.SQLException;
import java.util.List;

import kh.com.kshrd.ams.filtering.ArticleFilter;
import kh.com.kshrd.ams.models.Article;
import kh.com.kshrd.ams.utilities.Pagination;

public interface ArticleRepository extends BaseRepository<Article, Long, ArticleFilter>{
	public List<Article> findAllByCategoryId(Long id, Pagination pagination) throws SQLException;
	public Long count(Long categoryId) throws SQLException;
}
