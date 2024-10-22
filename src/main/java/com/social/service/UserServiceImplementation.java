package com.social.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.config.JwtProvider;
import com.social.exceptions.UserException;
import com.social.model.User;
import com.social.repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User deleteUser(Integer userId) {
		Optional<User> user = userRepository.findById(userId);
		return user.get();
	}

	@Override
	public User findUserById(Integer userId) throws UserException {
		Optional<User> user = userRepository.findById(userId);
		if (user == null) {
			throw new UserException("User id not found");
		}
		return user.get();
	}

	@Override
	public User registerUser(User user) {
		User newUser = new User();
		newUser.setEmail(user.getEmail());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setPassword(user.getPassword());
		newUser.setId(user.getId());
		newUser.setGender(user.getGender());

		User savedUser = userRepository.save(newUser);
		return savedUser;

	}

	@Override
	public User findUserByEmail(Integer userId) throws UserException

	{
		Optional<User> user = userRepository.findById(userId);
		if (user == null)
			throw new UserException("user id not found");

		User newUser = user.get();

		if (newUser.getEmail() == null) {
			throw new UserException("email id not found");
		}

		return user.get();

	}

	@Override
	public User followUser(Integer reqUserId, Integer userId2) throws UserException {
		User reqUser = findUserById(reqUserId);
		User user2 = findUserById(userId2);

		user2.getFollowers().add(reqUser.getId());
		reqUser.getFollowings().add(user2.getId());

		userRepository.save(reqUser);
		userRepository.save(user2);

		return reqUser;
	}

	@Override
	public User updateUser(User user, Integer userId) throws UserException {
		Optional<User> user1 = userRepository.findById(userId);

		if (user1.isEmpty()) {
			throw new UserException("User is Empty");
		}

		User oldUser = user1.get();

		if (user.getFirstName() != null) {
			oldUser.setFirstName(user.getFirstName());
		}
		if (user.getLastName() != null) {
			oldUser.setLastName(user.getLastName());
		}
		if (user.getEmail() != null) {
			oldUser.setEmail(user.getEmail());
		}

		if (user.getGender() != null) {
			oldUser.setGender(user.getGender());
		}
		User updatedUser = userRepository.save(oldUser);

		return updatedUser;
	}

	@Override
	public List<User> searchUser(String query) {
		List<User> users = userRepository.searchUser(query);
		return users;
	}

	@Override
	public User savedUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByJwt(String jwt) {

		String email = JwtProvider.getEmailFromJWTToken(jwt);
		User user = userRepository.findByEmail(email);
		return user;
	}

}
