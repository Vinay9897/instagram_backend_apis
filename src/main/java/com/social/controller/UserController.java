package com.social.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.social.model.User;
import com.social.repositories.UserRepository;
import com.social.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@GetMapping("/users/{userId}")
	public User getUserById(@PathVariable("userId") Integer id) throws Exception {

		User user = userService.findUserById(id);
		return user;
	}

	@PostMapping("/createUsers")
	public User createUser(@RequestBody User user) {

		User savedUser = userService.registerUser(user);

		return savedUser;
	}

	@PutMapping("/users/{userId}")
	public User updateUser(@RequestBody User user, @PathVariable Integer userId) throws Exception {

		User user1 = userService.updateUser(user);
		return user1;
	}

	@DeleteMapping("users/{userId}")
	public String deleteUser(@PathVariable("userId") Integer userId) throws Exception {

		User user = userService.deleteUser(userId);
		
		if(user == null)
			return "user not exist";
		
		userRepository.delete(user);

		return "user deleted successfully with id " + userId;
	}

	@PutMapping("/users/{userId1}/{userId2}")
	public User followUserHandler(@PathVariable Integer userId1, @PathVariable Integer userId2) throws Exception {
		return userService.followUser(userId1, userId2);
	}
	
	@GetMapping("/searchUsers/{query}")
	public List<User> searchUser(@PathVariable String query){
		List<User> users = userService.searchUser(query);
		return users;
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		
		return userRepository.findAll();
	}
	
	@DeleteMapping("/deleteAllUsers")
	public void deleteAllUsers() {
		
		userRepository.deleteAll();
		return;
	}
}
