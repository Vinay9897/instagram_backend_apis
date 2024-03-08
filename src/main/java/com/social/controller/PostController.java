package com.social.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.social.model.Post;
import com.social.service.PostService;

@RestController
public class PostController {
	
	@Autowired
	PostService postService;
	
	@PostMapping("/allPost")
	public ResponseEntity<Post> createPost(@RequestBody Post post, @PathVariable Integer userId) throws Exception {
		
		Post createdPost = postService.createNewPost(post, userId);
		return new ResponseEntity<>(createdPost, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/posts/{postId}/user/{userId}")
	public ResponseEntity<String> deletePost(@PathVariable Post post, @PathVariable Integer userId) throws Exception {
		
		String deletePost = postService.deletePost(userId, userId);
		return new ResponseEntity<String>(deletePost, HttpStatus.OK);
		
	}

}
