package kh.com.kshrd.ams.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kh.com.kshrd.ams.filtering.UserFilter;
import kh.com.kshrd.ams.models.User;
import kh.com.kshrd.ams.repositories.UserRepository;
import kh.com.kshrd.ams.services.UserService;
import kh.com.kshrd.ams.utilities.Pagination;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Override
	public User signUp(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		try {
			return userRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User signIn(User user) {
		try {
			User userLogined = userRepository.signIn(user);
			if (userLogined != null) {
				if (passwordEncoder.matches(user.getPassword(), userLogined.getPassword())) {
					return userLogined;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User signInFacebook(User user) {
		// TODO Auto-generated method stub
		try {
			User userLogined = userRepository.signIn(user);
			if (userLogined != null) {
				if (passwordEncoder.matches(user.getPassword(), userLogined.getPassword())) {
					return userLogined;
				}
			} else {
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				User userSignup = userRepository.signInFacebook(user);
				if (userSignup != null) {
					return userSignup;
				}
			}
		} catch (Exception e) {
			if (e instanceof EmptyResultDataAccessException) {
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				User userSignup = userRepository.signInFacebook(user);
				if (userSignup != null) {
					return userSignup;
				}
			}

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User updateProfile(User user) {
		try {
			return userRepository.update(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User deleteUserById(Long userId) {
		try {
			return userRepository.delete(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> findAllUsers(UserFilter filter, Pagination pagination) {
		try {
			return userRepository.findAll(filter, pagination);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User findUserById(User user) {
		try {
			return userRepository.findOne(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
