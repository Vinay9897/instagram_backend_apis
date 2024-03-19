package com.social.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.social.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		com.social.model.User user = userRepository.findByEmail(username);
		
		if(username == null)
		{
			throw new UsernameNotFoundException("user not found with email "+ username);
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		return new User(user.getEmail(),user.getPassword(), authorities);
	}

}
