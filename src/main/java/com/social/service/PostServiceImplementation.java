package com.social.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.model.Post;
import com.social.model.User;
import com.social.repositories.PostRepository;
import com.social.repositories.UserRepository;

@Service
public class PostServiceImplementation implements PostService{

	@Autowired
	PostRepository postRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;

	
	@Override
	public Post createNewPost(Post post, Integer userId) throws Exception {
		User user =  userService.findUserById(userId);
		Post newPost = new Post();
		newPost.setCaption(post.getCaption());
		newPost.setImage(post.getImage());
//		newPost.setCreatedAt(new LocalDate.now());
		newPost.setVideo(post.getVideo());
		newPost.setUser(user);
		
		return newPost;
	}

	@Override
	public String deletePost(Integer postId, Integer userId) throws Exception {
		Post post = null;
		try {
			 post = findPostById(postId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Optional<User> user = userRepository.findById(userId);
		if(post.getUser().getId() == user.get().getId())
		{
			throw new Exception("you can't delete another user post");
		}
		
		postRepository.delete(post);
		
		return "post deleted successfully";
	}

	@Override
	public List<Post> findAllPost() {
		// TODO Auto-generated method stub
		return postRepository.findAll();
	}

	@Override
	public Post findPostById(Integer postId) throws Exception {
		// TODO Auto-generated method stub
		Optional<Post> opt = postRepository.findById(postId);
		if(opt.isEmpty()) {
			throw new Exception("post not found with id "+ postId);
		}
		return opt.get();
	}

	@Override
	public Post savedPost(Integer postId, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> findPostByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post likePost(Integer postId, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
