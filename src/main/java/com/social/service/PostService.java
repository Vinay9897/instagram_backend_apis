package com.social.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.social.model.Post;

@Service
public interface PostService {
	
	Post createNewPost(Post post, Integer userId) throws Exception;
	
	String deletePost(Integer portId, Integer userId) throws Exception;
	
	List<Post> findPostByUserId(Integer userId);
	
	List<Post> findAllPost();
	
	Post findPostById(Integer postId) throws Exception;
	
	Post savedPost(Integer postId, Integer userId);
	
	Post likePost(Integer postId, Integer userId);

}
