package com.social.service;

import java.util.List;

import com.social.model.User;

public interface UserService {

	User registerUser(User user);
	User findUserById(Integer userId) throws Exception;
	User findUserByEmail(Integer userId) throws Exception;
	User followUser(Integer userId1 , Integer userId2) throws Exception;
	User updateUser(User user) throws Exception;
	List<User> searchUser(String query);
	


	
	User deleteUser(Integer userId);

	User savedUser(Integer userId);
}
