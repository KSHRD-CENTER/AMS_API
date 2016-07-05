package kh.com.kshrd.ams.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kh.com.kshrd.ams.models.User;
import kh.com.kshrd.ams.services.UploadService;
import kh.com.kshrd.ams.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User signUp(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return null;
	}

	@Override
	public User signIn(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User signInFacebook(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateProfile(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
