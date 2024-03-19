package com.social.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.model.Comment;
import com.social.model.User;
import com.social.service.CommentService;
import com.social.service.UserService;

@RestController
@RequestMapping("/api")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/comment/post/{postId}")
	public Comment createCommentHandler(@RequestBody Comment comment, @PathVariable("postId") Integer postId, @RequestHeader("Authorization") String jwt ) {
		
		User user = userService.findUserByJwt(jwt);
		Comment addComment = commentService.createComment(comment, postId, user.getId());
		
		return addComment;
	}
	
	@PutMapping("/comment/post/like/{commentId}")
	public Comment likeCommentHandler(@RequestBody Comment comment, @PathVariable("commentId") Integer commentId, @RequestHeader("Authorization") String jwt ) throws Exception {
		
		User user = userService.findUserByJwt(jwt);
		Comment likeComment = commentService.likeComment(commentId, user.getId());
		
		return likeComment; 
	}
	
	@GetMapping("/findcomment/{commentId}")
	public Comment getCommentHandler(@PathVariable("commentId") Integer commentId) throws Exception
	{
		Comment comm = commentService.getComment(commentId);
		return comm;
	}

}
