package com.social.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
