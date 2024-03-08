package com.social.service;

import java.util.List;

import com.social.model.User;

public interface UserService {

	User createNewUser(User user, Integer userId);

	User deleteUser(Integer userId);

	List<User> findAllUser();

	User findUserById(Integer userId);

	User savedUser(Integer userId);
}
