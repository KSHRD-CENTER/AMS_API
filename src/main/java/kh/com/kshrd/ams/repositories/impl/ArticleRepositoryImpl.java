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
import kh.com.kshrd.ams.models.User;
import kh.com.kshrd.ams.repositories.ArticleRepository;
import kh.com.kshrd.ams.repositories.BaseRepository;
import kh.com.kshrd.ams.utilities.Pagination;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Article save(Article article) throws SQLException {
		Long id = jdbcTemplate.queryForObject("SELECT nextval('articles_id_seq')", Long.class);
		int result = jdbcTemplate.update("INSERT INTO articles(id, "
										 + "title, "
				 						 + "description, "
				 						 + "created_date, "
				 						 + "user_id, "
				 						 + "status, "
				 						 + "category_id) "
						 + "VALUES(?, ?, ?, TO_CHAR(NOW(),'YYYYMMDDHH24MISS'), ?, '1', ?)"
						 , new Object[]{
								 		id,
								 		article.getTitle(),
								 		article.getDescription(),
								 		article.getAuthor().getId(),
								 		article.getCategory().getId()
						 				});
		if (result > 0) {
			System.out.println(id);
			return this.findOne(id);
		}
		return null;
	}

	@Override
	public Article update(Article article) throws SQLException {
		System.out.println("ARTICLE UPDATED ==> " + article);
		String sql = "UPDATE articles "
				   + "SET title = ? "
				   + "	, description = ? "
				   + "	, user_id = ? "
				   + "	, category_id = ? "
				   + "WHERE id = ?";
		int result = jdbcTemplate.update(sql, 
					new Object[] {
						article.getTitle(),
						article.getDescription(),
						article.getAuthor().getId(),
						article.getCategory().getId(),
						article.getId()
					});
		if (result > 0) {
			return this.findOne(article.getId());
		}
		return null;
	}

	@Override
	public boolean delete(Long id) throws SQLException {
		String sql = "UPDATE articles "
				   + "SET status = '0' "
				   + "WHERE id = ?";
		int result = jdbcTemplate.update(sql, new Object[] { id });
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Article> findAll(ArticleFilter filter, Pagination pagination) throws SQLException {
		String sql =  "SELECT A.id, "
					+ "	A.title, "
					+ " A.description, "
					+ " A.created_date, "
					+ " A.status, "
					+ " A.user_id, "
					+ " A.category_id, "
					+ " B.name AS category "
					+ "FROM articles A "
					+ "LEFT JOIN categories B ON A.category_id = B.id "
					+ "WHERE A.status = '1' "
					+ "LIMIT ? "
					+ "OFFSET ?";
	
		return jdbcTemplate.query(sql,
				new Object[]{
						pagination.getLimit(), 
						pagination.offset()
				}, 
				new RowMapper<Article>(){
					@Override
					public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
						Article article = new Article();
						article.setId(rs.getLong("id"));
						article.setTitle(rs.getString("title"));
						article.setDescription(rs.getString("description"));
						article.setCreatedDate(rs.getString("created_date"));
						article.setStatus(rs.getString("status"));
						
						User user = new User();
						user.setId(rs.getLong("user_id"));
						article.setAuthor(user);
						
						Category category = new Category();
						category.setId(rs.getLong("category_id"));
						category.setName(rs.getString("category"));
						article.setCategory(category);
						return article;
					}
		});
	}

	@Override
	public Article findOne(Long id) throws SQLException {
		String sql =  "SELECT A.id, "
					+ "	A.title, "
					+ " A.description, "
					+ " A.created_date, "
					+ " A.status, "
					+ " A.user_id, "
					+ " A.category_id, "
					+ " B.name AS category "
					+ "FROM articles A "
					+ "LEFT JOIN categories B ON A.category_id = B.id "
					+ "WHERE A.id = ? "
					+ "AND A.status = '1'";
		return jdbcTemplate.queryForObject(sql,
				new Object[]{id}, 
				new RowMapper<Article>(){
					@Override
					public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
						Article article = new Article();
						article.setId(rs.getLong("id"));
						article.setTitle(rs.getString("title"));
						article.setDescription(rs.getString("description"));
						article.setCreatedDate(rs.getString("created_date"));
						article.setStatus(rs.getString("status"));
						
						User user = new User();
						user.setId(rs.getLong("user_id"));
						article.setAuthor(user);
						
						Category category = new Category();
						category.setId(rs.getLong("category_id"));
						category.setName(rs.getString("category"));
						article.setCategory(category);
						return article;
					}
			});
	}

	@Override
	public List<Article> findAll(Pagination pagination) throws SQLException {
		return null;
	}

	@Override
	public List<Article> findAll(ArticleFilter fitler) throws SQLException {
		return null;
	}

	@Override
	public List<Article> findAll() throws SQLException {
		return null;
	}

	@Override
	public Long count() throws SQLException {
		return null;
	}
	
}
