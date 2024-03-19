package com.social.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.social.model.User;

@Service
public interface UserService {

	User registerUser(User user);
	User findUserById(Integer userId) throws Exception;
	User findUserByEmail(Integer userId) throws Exception;
	User followUser(Integer reqUserId , Integer userId2) throws Exception;
	User updateUser(User user, Integer userId) throws Exception;
	List<User> searchUser(String query);

	User deleteUser(Integer userId);

	User savedUser(Integer userId);
	
	User findUserByJwt(String jwt);
}
