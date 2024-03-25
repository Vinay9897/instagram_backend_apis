package com.social.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.model.User;
import com.social.repositories.UserRepository;
import com.social.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api")
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

	@PutMapping("/users")
	public User updateUser(@RequestBody User user, @RequestHeader("Authorization") String jwt) throws Exception {
		System.out.println("inside update");
		User reqUser = userService.findUserByJwt(jwt); 
		System.out.println(reqUser);
		User user1 = userService.updateUser(user,reqUser.getId());
		return user1;
	}

	@DeleteMapping("/users")
	public String deleteUser(@RequestHeader("Authorization") String jwt) throws Exception {

		User reqUser = userService.findUserByJwt(jwt);
		Integer userId = reqUser.getId();
		User user = userService.deleteUser(userId);
		
		if(user == null)
			return "user not exist";
		
		userRepository.delete(user);

		return "user deleted successfully with id " + userId;
	}

	@PutMapping("/users/{userId2}")
	public User followUserHandler(@RequestHeader("Authorization") String jwt, @PathVariable Integer userId2) throws Exception {
		 
		User reqUser = userService.findUserByJwt(jwt);
		Integer reqUserId = reqUser.getId();
		return userService.followUser(reqUserId, userId2);
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
	
	@GetMapping("/users/profile")
	public User getUserFromTokenHandler(@RequestHeader("Authorization") String jwt)
	{
		User user = userService.findUserByJwt(jwt);
		System.out.println(user);
		return user;
	}
}
