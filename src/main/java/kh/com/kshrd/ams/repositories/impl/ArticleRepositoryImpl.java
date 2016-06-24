package kh.com.kshrd.ams.repositories.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kh.com.kshrd.ams.filtering.ArticleFilter;
import kh.com.kshrd.ams.models.Article;
import kh.com.kshrd.ams.models.Category;
import kh.com.kshrd.ams.repositories.ArticleRepository;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean save(Article article) throws SQLException {
		return false;
	}

	@Override
	public boolean updateArticle(Article article) throws SQLException {
		return false;
	}

	@Override
	public boolean deleteArticle(Long id) throws SQLException {
		return false;
	}

	@Override
	public List<Article> findAllArticles(ArticleFilter fitler) throws SQLException {
		String sql =  "SELECT A.id, "
					+ "	A.title, "
					+ " A.description, "
					+ " A.created_date, "
					+ " A.status, "
					+ " A.author, "
					+ " A.category_id, "
					+ " B.name AS category "
					+ "FROM articles A "
					+ "LEFT JOIN categories B ON A.category_id = B.id ";
		return jdbcTemplate.query(sql, new RowMapper<Article>(){
			@Override
			public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
				Article article = new Article();
				article.setId(rs.getLong("id"));
				article.setTitle(rs.getString("title"));
				article.setDescription(rs.getString("description"));
				article.setCreatedDate(rs.getString("created_date"));
				article.setStatus(rs.getString("status"));
				article.setAuthor(rs.getString("author"));
				
				Category category = new Category();
				category.setId(rs.getLong("category_id"));
				category.setName(rs.getString("category"));
				article.setCategory(category);
				return article;
			}
		});
	}

	@Override
	public Article findArticleById(Long id) throws SQLException {
		String sql =  "SELECT A.id, "
				+ "	A.title, "
				+ " A.description, "
				+ " A.created_date, "
				+ " A.status, "
				+ " A.author, "
				+ " A.category_id, "
				+ " B.name AS category "
				+ "FROM articles A "
				+ "LEFT JOIN categories B ON A.category_id = B.id "
				+ "WHERE A.id = ? ";
	return jdbcTemplate.queryForObject(sql,new Object[]{id}, new RowMapper<Article>(){
		@Override
		public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
			Article article = new Article();
			article.setId(rs.getLong("id"));
			article.setTitle(rs.getString("title"));
			article.setDescription(rs.getString("description"));
			article.setCreatedDate(rs.getString("created_date"));
			article.setStatus(rs.getString("status"));
			article.setAuthor(rs.getString("author"));
			
			Category category = new Category();
			category.setId(rs.getLong("category_id"));
			category.setName(rs.getString("category"));
			article.setCategory(category);
			return article;
		}
	});
	}
	
	

}
