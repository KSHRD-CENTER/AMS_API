package kh.com.kshrd.ams.repositories.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kh.com.kshrd.ams.filtering.CategoryFilter;
import kh.com.kshrd.ams.models.Category;
import kh.com.kshrd.ams.repositories.CategoryRepository;
import kh.com.kshrd.ams.utilities.Pagination;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Category> findAll(CategoryFilter fitler) throws SQLException {
		String sql =  "SELECT A.id, "
					+ "	A.name, "
					+ "	A.status, "
					+ " B.name AS parent "
				   + "FROM categories A "
				   + "LEFT JOIN categories B ON A.parent_id = B.id";
		return jdbcTemplate.query(sql,
				new RowMapper<Category>(){
					@Override
					public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
						Category category = new Category();
						category.setId(rs.getLong("id"));
						category.setName(rs.getString("name"));
						category.setStatus(rs.getString("status"));
						return category;
					}
		});

	}

	@Override
	public Category findOne(Long id) throws SQLException {
		String sql =  "SELECT A.id, "
				+ "	A.name, "
				+ "	A.status, "
				+ " B.name AS parent "
			   + "FROM categories A "
			   + "LEFT JOIN categories B ON A.parent_id = B.id "
			   + "WHERE A.id = ?";
		return jdbcTemplate.queryForObject(sql,
				new Object[]{id},
				new RowMapper<Category>(){
					@Override
					public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
						Category category = new Category();
						category.setId(rs.getLong("id"));
						category.setName(rs.getString("name"));
						category.setStatus(rs.getString("status"));
						return category;
					}
		});
	}

	@Override
	public Category save(Category category) throws SQLException {

		Long id = jdbcTemplate.queryForObject("SELECT nextval('categories_id_seq')", Long.class);
		String sql = "INSERT INTO categories (id, name, status, parent_id) "
				   + "VALUES (?, ?, '1', ?)";
		int result = jdbcTemplate.update(sql,
					new Object[]{
							id,
							category.getName(),
							category.getParent()
						});
		if (result > 0){
			return this.findOne(id);
		}
		return null;
	}

	@Override
	public boolean delete(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Category update(Category category) throws SQLException {
		String sql = "UPDATE categories "
				   + "SET name = ?, "
				   +  "status = ?, "
				   +  "parent_id = ? "
				   + "WHERE id = ?";
		
		int result = jdbcTemplate.update(sql,
						new Object[]{
							category.getName(),
							category.getStatus(),
							category.getParent().getId(),
							category.getId()
						});
		if (result > 0){
			return this.findOne(category.getId());
		}
		return null;
	}

	@Override
	public List<Category> findAll(Pagination pagination) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findAll(CategoryFilter fitler, Pagination pagination) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
