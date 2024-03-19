package com.social.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.social.model.Reels;
import com.social.model.User;

@Service
public interface ReelsService {
	
	public Reels addReels(Reels reels , User user);
	
	public List<Reels> findAllReels();
	
	public List<Reels> findUserReels(Integer userId) throws Exception;
	
	public Reels deleteReels(Integer reelId) throws Exception;
	
	public Reels likeReels();

}
