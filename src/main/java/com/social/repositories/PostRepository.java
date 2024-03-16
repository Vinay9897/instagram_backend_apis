package com.social.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.social.model.Post;

public interface PostRepository extends JpaRepository<Post,Integer> {
	
	public List<Post> findPostByUserId(@Param("user_id") Integer userId);

}
