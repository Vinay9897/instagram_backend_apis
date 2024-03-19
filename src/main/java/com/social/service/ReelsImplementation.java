package com.social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.model.Reels;
import com.social.model.User;
import com.social.repositories.ReelsRepository;

@Service
public class ReelsImplementation implements ReelsService{
	
	@Autowired
	ReelsRepository reelsRepository;
	
	@Autowired
	ReelsService reelsService;
	
	@Autowired
	UserService userService;

	@Override
	public Reels addReels(Reels reels, User user) {
		Reels createReels = new Reels();
		createReels.setVideo(reels.getVideo());
		createReels.setTitle(reels.getTitle());
		createReels.setUser(user);
		reelsRepository.save(createReels);
		return createReels;
	}

	@Override
	public List<Reels> findAllReels() {
		return reelsRepository.findAll();
	}

	@Override
	public List<Reels> findUserReels(Integer userId) throws Exception {
		User user = userService.findUserById(userId);
		if(user == null)
		   throw new Exception("user not exist");
		
		return reelsRepository.findByUserId(userId) ;
	}

	@Override
	public Reels deleteReels(Integer reelId) throws Exception {
		
		Reels reels = reelsRepository.findById(reelId).get();
		
		if(reels == null)
			throw new Exception("Reels not exist");
		
		reelsRepository.delete(reels);
		return reels;
	}

	@Override
	public Reels likeReels() {
	
		return null;
	}

}
