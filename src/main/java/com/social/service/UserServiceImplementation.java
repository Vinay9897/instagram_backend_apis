package com.social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.model.User;
import com.social.repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User createNewUser(User user, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User savedUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
