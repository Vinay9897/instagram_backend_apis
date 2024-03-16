package com.social.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.social.model.Post;
import com.social.model.User;
import com.social.repositories.PostRepository;
import com.social.repositories.UserRepository;

@Service
public class PostServiceImplementation implements PostService {

	@Autowired
	PostRepository postRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@Override
	public Post createNewPost(Post post, Integer userId) throws Exception {
		User user = userService.findUserById(userId);
		Post newPost = new Post();
		newPost.setId(post.getId());
		newPost.setCaption(post.getCaption());
		newPost.setImage(post.getImage());
		newPost.setCreatedAt(LocalDateTime.now());
		newPost.setVideo(post.getVideo());
		newPost.setUser(user);
		postRepository.save(newPost);
		return newPost;
	}

	@Override
	public String deletePost(Integer postId, Integer userId) throws Exception {
		Post post = null;
		post = findPostById(postId);

		User user = userService.findUserById(userId);
		if (post.getUser().getId().equals(user.getId())) {
			throw new Exception("you can't delete another user post");
		}

		postRepository.delete(post);

		return "post deleted successfully";
	}

	@Override
	public List<Post> findAllPost() {
		return postRepository.findAll();
	}

	@Override
	public Post findPostById(Integer postId) throws Exception {
		Optional<Post> opt = postRepository.findById(postId);
		if (opt.isEmpty()) {
			throw new Exception("post not found with id " + postId);
		}
		return opt.get();
	}

	@Override
	public Post savedPost(Integer postId, Integer userId) throws Exception {
		Post post = findPostById(postId);
		User user = userService.findUserById(userId);
		if (user.getSavedPost().contains(post)) {
			System.out.println("post contains");
			user.getSavedPost().remove(post);
		} else {
			System.out.println("post add");
			user.getSavedPost().add(post);
		}
		userRepository.save(user);
		return post;
	}

	@Override
	public List<Post> findPostByUserId(Integer userId) {
		// TODO Auto-generated method stub
		List<Post> list = postRepository.findPostByUserId(userId);
		return list;
	}

	@Override
	public Post likePost(Integer postId, Integer userId) throws Exception {
		Post post = findPostById(postId);
		User user = userService.findUserById(userId);

		post.getLiked().add(user.getId());

		postRepository.save(post);

		return post;

	}

}
