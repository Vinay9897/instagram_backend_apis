package com.social.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.social.model.Post;
import com.social.response.ApiResponse;
import com.social.service.PostService;

@RestController
public class PostController {

	@Autowired
	PostService postService;

	@PostMapping("/posts/user/{userId}")
	public ResponseEntity<Post> createPost(@RequestBody Post post, @PathVariable Integer userId) throws Exception {

		Post createdPost = postService.createNewPost(post, userId);
		return new ResponseEntity<>(createdPost, HttpStatus.OK);
	}

	@DeleteMapping("/posts/{postId}/user/{userId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable Post postId, @PathVariable Integer userId)
			throws Exception {

		String message = postService.deletePost(userId, userId);
		ApiResponse response = new ApiResponse(true, message);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	
	@GetMapping("/findposts/{userId}")
	public ResponseEntity<List<Post>> findUsersPost(@PathVariable Integer userId) {

		List<Post> list = postService.findPostByUserId(userId);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/posts")
	public ResponseEntity<List<Post>> findAllPost() {

		List<Post> list = postService.findAllPost();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("posts/{postId}")
	public ResponseEntity<Post> findPostByIdHandler(@PathVariable Integer postId) throws Exception {

		Post post = postService.findPostById(postId);
		return new ResponseEntity<>(post, HttpStatus.OK);

	}
	
	@PutMapping("/posts/{postId}/user/{userId}")
	public ResponseEntity<Post> savedPostHandler(@PathVariable Integer postId, @PathVariable Integer userId) throws Exception {
		
		Post post = postService.savedPost(postId, userId);
		return new ResponseEntity<>(post,HttpStatus.OK);
	}

	@PutMapping("/posts/like/{postId}/user/{userId}")
	public ResponseEntity<Post> likePost(@PathVariable Integer postId,@PathVariable Integer userId) throws Exception {
		
		Post post = postService.likePost(postId, userId);
		return new ResponseEntity<>(post,HttpStatus.OK);
	}
	
}
