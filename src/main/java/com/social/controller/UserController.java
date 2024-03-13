package com.social.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	@GetMapping("/users")
	public List<User> getUsers() {

		List<User> users = new ArrayList<>();

		User user1 = new User(1, "code", "zosh", "codewithzosh@gmail.com", "12345");
		User user2 = new User(2, "raam", "arora", "raam@gmail.com", "12345");

		users.add(user1);
		users.add(user2);

		return users;
	}

	@GetMapping("/users/{userId}")
	public User getUserById(@PathVariable("userId") Integer id) throws Exception {

		User user = userService.findUserById(id);
		return user;
	}

	@PostMapping("/users")
	public User createser(@RequestBody User user) {

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
	
	public List<User> searchUser(@RequestParam("query") String query){
		List<User> users = userService.searchUser(query);
		return users;
	}
}
