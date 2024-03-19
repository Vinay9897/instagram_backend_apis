package com.social.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.model.Story;
import com.social.model.User;
import com.social.repositories.StoryRepository;
import com.social.service.StoryService;
import com.social.service.UserService;

@RestController
@RequestMapping("/api")
public class StoryController {
	
	@Autowired
	StoryService storyService;
	
	@Autowired
	UserService  userService;
	
	
	@PostMapping("/addstory")
	public Story addStory(@RequestBody Story story, @RequestHeader("Authorization") String jwt) throws Exception {
		User user = userService.findUserByJwt(jwt);
		
		Integer userId = user.getId();
		Story newStory = storyService.createStory(story, userId);
		
		return newStory;
	}
	
	@GetMapping("/story/user/{userId}")
	public List<Story> findUserStory(@RequestHeader("Authorization") String jwt) throws Exception {
		User user = userService.findUserByJwt(jwt);
		
		Integer userId = user.getId();
		List<Story> newStory = storyService.findStoryByUserId(userId);
		
		return newStory;
	}
	
	@DeleteMapping("/story/{storyId}")
	public Story deletUserStory(@RequestHeader("Authorization") String jwt,@PathVariable Integer storyId) throws Exception {
		Story story = storyService.deleteStory(storyId);
		
		return story;
	}

}
