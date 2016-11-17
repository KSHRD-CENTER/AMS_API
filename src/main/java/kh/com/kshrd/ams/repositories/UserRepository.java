package kh.com.kshrd.ams.repositories;

import java.util.List;

import kh.com.kshrd.ams.filtering.UserFilter;
import kh.com.kshrd.ams.models.User;
import kh.com.kshrd.ams.utilities.Pagination;

public interface UserRepository {

	//TODO: TO SIGN UP A NEW USER
	public User save(User user);
	
	//TODO: TO SIGN IN USER
	public User findOne(Long id);
	
	//TODO: TO FIND ALL USERS
	public List<User> findAll(UserFilter filter, Pagination pagination) ;
	
	public User update(User user);
	
	public User delete(Long id);
	
	public User signIn(User user);
	
	public Long count(UserFilter filter) ;
}
