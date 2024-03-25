package com.social.service;

import org.springframework.stereotype.Service;

import com.social.model.Comment;

@Service
public interface CommentService {
	
	public Comment createComment(Comment comment, Integer postId, Integer userId);
	
	public Comment likeComment(Integer commentId, Integer userId) throws Exception;
	
	public Comment getComment(Integer commentid) throws Exception;
	
	public Comment deleteComment(Integer postId,Integer commentId) throws Exception;
}
