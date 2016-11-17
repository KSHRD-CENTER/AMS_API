package kh.com.kshrd.ams.services;

import java.util.List;

import kh.com.kshrd.ams.filtering.UserFilter;
import kh.com.kshrd.ams.models.User;
import kh.com.kshrd.ams.utilities.Pagination;

public interface UserService {
	
	//TODO: TO SIGNUP SERVICE
	public User signUp(User user);
	
	//TODO: TO SIGN IN SERVICE
	public User signIn(User user);
	
	//TODO: TO SIGN IN WITH FACEBOOK
	public User signInFacebook(User user);
	
	//TODO: TO UPDATE USER PROFILE
	public User updateProfile(User user);
	
	//TODO: TO DELETE USER BY ID
	public User deleteUserById(Long userId);
	
	//TODO: TO FIND ALL USERS
	public List<User> findAllUsers(UserFilter filter, Pagination pagination);

	//TODO: TO FIND USER BY ID
	public User findUserById(User user);
	
}
