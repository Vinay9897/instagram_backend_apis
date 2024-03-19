package com.social.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.social.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
	public User findByEmail(String email);
	
	public User findUserById(Integer userId) throws Exception;
	
	@Query("select u from User u where u.firstName LIKE %:query% OR u.lastName LIke %:query% OR u.email LIKE %:query")
	public List<User> searchUser(@Param("query") String query);
	

}
