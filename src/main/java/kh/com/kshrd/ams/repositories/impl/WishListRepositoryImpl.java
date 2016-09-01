package kh.com.kshrd.ams.repositories.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kh.com.kshrd.ams.models.Article;
import kh.com.kshrd.ams.models.Category;
import kh.com.kshrd.ams.models.User;
import kh.com.kshrd.ams.models.WishList;
import kh.com.kshrd.ams.repositories.WishListRepository;
import kh.com.kshrd.ams.utilities.Pagination;

@Repository
public class WishListRepositoryImpl implements WishListRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public WishList save(WishList wishList) {
		Long id = jdbcTemplate.queryForObject("SELECT nextval('wishlists_id_seq')", Long.class);
		int result = jdbcTemplate.update("INSERT INTO wishlists(id, "
										 + "user_id, "
				 						 + "article_id, "
				 						 + "created_date, "
				 						 + "status) "
						 + "VALUES(?, ?, ?, TO_CHAR(NOW(),'YYYYMMDDHH24MISS'),'1')"
						 , new Object[]{
								 		id,
								 		wishList.getUserId(),
								 		wishList.getArticle().getId()
						 				});
		if (result > 0) {
			System.out.println(id);
			return this.findOne(id);
		}
		return null;
	}

	@Override
	public boolean delete(Long id) {
		String sql = "UPDATE wishlists "
				   + "SET status = '0' "
				   + "WHERE id = ?";
		int result = jdbcTemplate.update(sql, new Object[] { id });
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<WishList> findAllByUserId(Long id, Pagination pagination) {
		pagination.setTotalCount(this.count(id));
		String sql =  "SELECT A.id, "
					+ "	A.user_id, "
					+ " A.article_id, "
					+ " A.created_date, "
					+ " A.status, "
					+ " B.id AS article_id, "
					+ " B.title, "
					+ " B.description, "
					+ " B.created_date As article_created_date, "
					+ " B.status AS article_status, "
					+ " B.image, "
					+ " C.name AS author, "
					+ " C.id AS author_id, "
					+ " D.name AS category, "
					+ " D.id AS category_id "
					+ "FROM wishlists A "
					+ "INNER JOIN articles B ON A.article_id = B.id AND B.status = '1' "
					+ "LEFT JOIN users C ON B.user_id = C.id AND C.status = '1' "
					+ "LEFT JOIN categories D ON B.category_id = D.id AND D.status = '1' "
					+ "WHERE A.status = '1' "
					+ "AND A.user_id = ? "
					+ "LIMIT ? "
					+ "OFFSET ? ";
		return jdbcTemplate.query(sql,
			new Object[]{
				id,
				pagination.getLimit(),
				pagination.offset()
			}, 
			new RowMapper<WishList>(){
				@Override
				public WishList mapRow(ResultSet rs, int rowNum) throws SQLException {
					WishList wishList = new WishList();
					Article article = new Article();
					article.setId(rs.getLong("article_id"));
					article.setTitle(rs.getString("title"));
					article.setDescription(rs.getString("description"));
					article.setCreatedDate(rs.getString("created_date"));
					article.setStatus(rs.getString("article_status"));
					article.setImage(rs.getString("image"));
					
					User user = new User();
					user.setId(rs.getLong("author_id"));
					user.setName(rs.getString("author"));
					article.setAuthor(user);
					
					Category category = new Category();
					category.setId(rs.getLong("category_id"));
					category.setName(rs.getString("category"));
					article.setCategory(category);
					
					wishList.setId(rs.getLong("id"));
					wishList.setArticle(article);
					wishList.setUserId(rs.getLong("user_id"));
					wishList.setCreatedDate(rs.getString("created_date"));
					wishList.setStatus(rs.getString("status"));
					return wishList;
				}
			});
	}

	@Override
	public Long count(Long id) {
		try{
			String sql =  "SELECT COUNT(A.id) "
						+ "FROM wishlists A "
						+ "WHERE A.status = '1' "
						+ "AND A.user_id = ?";
			return jdbcTemplate.queryForObject(
					sql,
					new Object[]{
						id	
					},
					Long.class
			);
		}catch(Exception ex){
			ex.printStackTrace();
			return 0L;
		}
	}

	@Override
	public WishList findOne(Long id) {
		String sql =  "SELECT A.id, "
					+ "	A.user_id, "
					+ " A.article_id, "
					+ " A.created_date, "
					+ " A.status, "
					+ " B.id AS article_id, "
					+ " B.title, "
					+ " B.description, "
					+ " B.created_date As article_created_date, "
					+ " B.status AS article_status, "
					+ " B.image, "
					+ " C.name AS author, "
					+ " C.id AS author_id, "
					+ " D.name AS category, "
					+ " D.id AS category_id "
					+ "FROM wishlists A "
					+ "INNER JOIN articles B ON A.article_id = B.id AND B.status = '1' "
					+ "LEFT JOIN users C ON B.user_id = C.id AND C.status = '1' "
					+ "LEFT JOIN categories D ON B.category_id = D.id AND D.status = '1' "
					+ "WHERE A.id = ? "
					+ "AND A.status = '1'";
		return jdbcTemplate.queryForObject(sql,
			new Object[]{
				id
			}, 
			new RowMapper<WishList>(){
				@Override
				public WishList mapRow(ResultSet rs, int rowNum) throws SQLException {
					WishList wishList = new WishList();
					Article article = new Article();
					article.setId(rs.getLong("article_id"));
					article.setTitle(rs.getString("title"));
					article.setDescription(rs.getString("description"));
					article.setCreatedDate(rs.getString("created_date"));
					article.setStatus(rs.getString("article_status"));
					article.setImage(rs.getString("image"));
					
					User user = new User();
					user.setId(rs.getLong("author_id"));
					user.setName(rs.getString("author"));
					article.setAuthor(user);
					
					Category category = new Category();
					category.setId(rs.getLong("category_id"));
					category.setName(rs.getString("category"));
					article.setCategory(category);
					
					wishList.setId(rs.getLong("id"));
					wishList.setArticle(article);
					wishList.setUserId(rs.getLong("user_id"));
					wishList.setCreatedDate(rs.getString("created_date"));
					wishList.setStatus(rs.getString("status"));
					return wishList;
				}
		});
	}
	
}
