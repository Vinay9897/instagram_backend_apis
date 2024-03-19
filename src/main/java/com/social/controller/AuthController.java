package com.social.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.social.config.JwtProvider;
import com.social.model.User;
import com.social.repositories.UserRepository;
import com.social.response.AuthResponse;
import com.social.response.LoginRequest;
import com.social.service.CustomUserDetailsService;

@RestController
public class AuthController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	CustomUserDetailsService customUserDetailsService;

	@PostMapping("/registration")
	public AuthResponse createUser(@RequestBody User user) throws Exception {

		User list = userRepository.findByEmail(user.getEmail());

		if (list != null) {
			throw new Exception("email is already exist");
		}

		User newUser = new User();
		newUser.setEmail(user.getEmail());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		newUser.setGender(user.getGender());

		User savedUser = userRepository.save(newUser);

		Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(),
				savedUser.getPassword());
		String token = JwtProvider.generateToken(authentication);

		AuthResponse response = new AuthResponse(token, "Register Successful");
		return response;
	}

	@PostMapping("/login")
	public AuthResponse loginUser(@RequestBody LoginRequest lRequest) {
		Authentication authentication = authenticate(lRequest.getEmail(), lRequest.getPassword());
		
		String token = JwtProvider.generateToken(authentication);
		AuthResponse response = new AuthResponse(token, "Login Successful");
		return response;
	}

	private Authentication authenticate(String email, String password) {
		UserDetails userDetails = customUserDetailsService.loadUserByUsername(email);

		if (userDetails == null) {
			throw new BadCredentialsException("invalid username");
		}

		if (!passwordEncoder.matches(password, userDetails.getPassword())) {
			throw new BadCredentialsException("password not matched");
		}
		return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	}
}
