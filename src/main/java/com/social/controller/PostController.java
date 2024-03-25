package com.social.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.social.model.Post;
import com.social.model.User;
import com.social.response.ApiResponse;
import com.social.service.PostService;
import com.social.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PostController {

	@Autowired
	PostService postService;
	
	@Autowired
	UserService userService;

	@PostMapping("/posts/user")
	public ResponseEntity<Post> createPost(@RequestBody Post post,@RequestHeader("Authorization") String jwt ) throws Exception {
		
		User user = userService.findUserByJwt(jwt);
		System.out.println(user);
		Integer userId = user.getId();
		System.out.println("userId"+userId);
		Post createdPost = postService.createNewPost(post, userId);
		return new ResponseEntity<>(createdPost, HttpStatus.OK);
	}

	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId, @RequestHeader("Authorization") String jwt)
			throws Exception {

		User user = userService.findUserByJwt(jwt);
		Integer userId = user.getId();
		String message = postService.deletePost(postId, userId);
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
	
	@PutMapping("/posts/{postId}")
	public ResponseEntity<Post> savedPostHandler(@PathVariable Integer postId, @RequestHeader("Authorization") String jwt) throws Exception {
		
		User user  = userService.findUserByJwt(jwt);
		Integer userId = user.getId();
		
		Post post = postService.savedPost(postId, userId);
		return new ResponseEntity<>(post,HttpStatus.OK);
	}

	@PutMapping("/posts/like/{postId}")
	public ResponseEntity<Post> likePost(@PathVariable Integer postId,@RequestHeader("Authorization") String jwt) throws Exception {
		
		User user = userService.findUserByJwt(jwt);
		Integer userId = user.getId();
		Post post = postService.likePost(postId, userId);
		return new ResponseEntity<>(post,HttpStatus.OK);
	}
	
}
