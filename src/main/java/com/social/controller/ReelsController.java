package com.social.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.model.Reels;
import com.social.model.User;
import com.social.service.ReelsService;
import com.social.service.UserService;

@RestController()
@CrossOrigin
@RequestMapping("/api")
public class ReelsController {
	
	
	@Autowired
	ReelsService reelsService;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/createreels")
	public Reels createReelsHandler(@RequestBody Reels reel, @RequestHeader("Authorization") String jwt) {
		
		User reqUser = userService.findUserByJwt(jwt);
		
		Reels createdReels = reelsService.addReels(reel, reqUser);
		return createdReels;
	}
	
	@GetMapping("/finduserreels")
	public List<Reels> findReelsHandler(@RequestBody Reels reel, @RequestHeader("Authorization") String jwt) throws Exception {
		
		User reqUser = userService.findUserByJwt(jwt);
		
		List<Reels> createdReels = reelsService.findUserReels(reqUser.getId());
		return createdReels;
	}
	
	@GetMapping("/findAllreels")
	public List<Reels> findAllRealsHandler()
	{
		return reelsService.findAllReels();
	}
	
}
