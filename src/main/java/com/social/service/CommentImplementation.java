package com.social.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.model.Comment;
import com.social.model.Post;
import com.social.model.User;
import com.social.repositories.CommentRepository;
import com.social.repositories.PostRepository;
import com.social.repositories.UserRepository;

@Service
public class CommentImplementation implements CommentService {

	private UserService userService;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	public CommentImplementation(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public Comment createComment(Comment comment, Integer postId, Integer userId) {
		Post post = postRepository.findById(postId).get();
		
		User user = userRepository.findById(userId).get();		
		
		Comment comm = new Comment();
		comm.setUser(user);
		comm.setContent(comment.getContent());
		comm.setLocalDateTime(LocalDateTime.now());
		
		Comment savedComment = commentRepository.save(comm);
		post.getComment().add(savedComment);
		postRepository.save(post);
		
		return savedComment;
	}

	@Override
	public Comment likeComment(Integer commentId, Integer userId) throws Exception {
		Comment comm = getComment(commentId);
		User user = userService.findUserById(userId); 
		
		if(!comm.getLiked().contains(user))
		{
			comm.getLiked().add(user);
		}
		else {
			comm.getLiked().remove(user);
		}
		
		return commentRepository.save(comm);
	}

	@Override
	public Comment getComment(Integer commentid) throws Exception {
		Comment opt = commentRepository.findById(commentid).get();
		if(opt == null)
		{
			throw new Exception("comment id not found");
		}
		
		return opt;
	}

}
