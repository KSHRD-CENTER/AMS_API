package kh.com.kshrd.ams.repositories.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kh.com.kshrd.ams.models.User;
import kh.com.kshrd.ams.repositories.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User save(User user) {
		Long id = jdbcTemplate.queryForObject("SELECT nextval('articles_id_seq')", Long.class);
		int result = jdbcTemplate.update("INSERT INTO users("
										 + "id, "
										 + "name, "
										 + "password, "
										 + "email, "
				 						 + "gender, "
				 						 + "telephone, "
				 						 + "status, "
				 						 + "image_url, "
				 						 + "facebook_id) "
						 + "VALUES(?, ?, ?, ?, ?, ?, '1', ?, ?)"
						 , new Object[]{
						 		id,
						 		user.getName(),
						 		user.getPassword(),
						 		user.getEmail(),
						 		user.getGender(),
						 		user.getTelephone(),
						 		user.getImageUrl(),
						 		user.getFacebookId()
				 	});
		if (result > 0) {
			System.out.println(id);
			return this.findOne(id);
		}
		return null;
	}

	@Override
	public User findOne(Long id) {
		String sql =  "SELECT id, "
					+ "	name, "
					+ " password, "
					+ " gender, "
					+ " email, "
					+ " telephone, "
					+ " status, "
					+ " image_url, "
					+ " facebook_id "
					+ "FROM users "
					+ "WHERE status = '1' "
					+ "AND id = ?";

	return jdbcTemplate.queryForObject(sql,
			new Object[]{id},
			new RowMapper<User>(){
				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					User user = new User();
					user.setId(rs.getLong("id"));
					user.setName(rs.getString("name"));
					user.setPassword(rs.getString("password"));
					user.setEmail(rs.getString("email"));
					user.setGender(rs.getString("gender"));
					user.setTelephone(rs.getString("telephone"));
					user.setStatus(rs.getString("status"));
					user.setImageUrl(rs.getString("image_url"));
					user.setFacebookId(rs.getString("facebook_id"));
					return user;
				}
		});
	}

	@Override
	public List<User> findAll() {
		String sql =  "SELECT id, "
					+ "	name, "
					+ " password, "
					+ " gender, "
					+ " email, "
					+ " telephone, "
					+ " status, "
					+ " image_url, "
					+ " facebook_id "
					+ "FROM users "
					+ "WHERE status = '1' ";
	
		return jdbcTemplate.query(sql,
				new RowMapper<User>(){
					@Override
					public User mapRow(ResultSet rs, int rowNum) throws SQLException {
						User user = new User();
						user.setId(rs.getLong("id"));
						user.setName(rs.getString("name"));
						user.setEmail(rs.getString("email"));
						user.setGender(rs.getString("gender"));
						user.setTelephone(rs.getString("telephone"));
						user.setStatus(rs.getString("status"));
						user.setImageUrl(rs.getString("image_url"));
						user.setFacebookId(rs.getString("facebook_id"));
						return user;
					}
		});
	}

	@Override
	public User update(User user) {
		String sql = "UPDATE users "
				   + " SET name = ?, "
				   + " gender = ?, "
				   + " telephone = ?, "
				   + " status = ?"
				   + " image_url = ? "
				   + "WHERE id = ?";
		int result = jdbcTemplate.update(sql,
				new Object[]{
			 		user.getName(),
			 		user.getGender(),
			 		user.getTelephone(),
			 		"1",
			 		user.getImageUrl(),
			 		user.getId()
				});
		if (result > 0) {
			return this.findOne(user.getId());
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		String sql = "UPDATE users "
				   + "SET status = '0' "
				   + "WHERE id = ?";
		int result = jdbcTemplate.update(sql, new Object[]{id});
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public User signIn(User user) {
		String sql =  "SELECT * "
				+ "FROM users "
				+ "WHERE status = '1' AND email = ?";
		
		return jdbcTemplate.queryForObject(sql, 
				new Object[]{
						user.getEmail(),
				},
				new RowMapper<User>(){
					@Override
					public User mapRow(ResultSet rs, int arg1) throws SQLException {
						// TODO Auto-generated method stub
						User user = new User();
						user.setId(rs.getLong("id"));
						user.setName(rs.getString("name"));
						user.setPassword(rs.getString("password"));
						user.setEmail(rs.getString("email"));
						user.setGender(rs.getString("gender"));
						user.setTelephone(rs.getString("telephone"));
						user.setStatus(rs.getString("status"));
						user.setImageUrl(rs.getString("image_url"));
						user.setFacebookId(rs.getString("facebook_id"));
						return user;
					};
		
		});
	
	}
}
