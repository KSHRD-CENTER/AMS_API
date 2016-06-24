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

@Repository
public class CategoryRepositoryImpl implements CategoryRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Category> findAllArticles(CategoryFilter fitler) throws SQLException {
		String sql =  "SELECT A.id, "
					+ "	A.name, "
					+ "	A.status, "
					+ " B.name AS parent "
				   + "FROM categories A "
				   + "LEFT JOIN categories B ON A.parent_id = B.id ";
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

}
