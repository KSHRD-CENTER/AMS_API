package kh.com.kshrd.ams.repositories;

import java.util.List;

import kh.com.kshrd.ams.models.User;

public interface UserRepository {

	//TODO: TO SIGN UP A NEW USER
	public User save(User user);
	
	//TODO: TO SIGN IN USER
	public User findOne(User user);
	
	//TODO: TO FIND ALL USERS
	public List<User> findAll();
}
