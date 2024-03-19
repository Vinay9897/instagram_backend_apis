package com.social.service;

import java.time.LocalDateTime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.model.Story;
import com.social.model.User;
import com.social.repositories.StoryRepository;
import com.social.repositories.UserRepository;

@Service
public class StoryImplementation implements StoryService {
	
	@Autowired
	StoryRepository storyRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public Story createStory(Story story, Integer userId) throws Exception {
		Story addStory =  new Story();
		User user = userRepository.findUserById(userId);
		addStory.setCaptions(story.getCaptions());
		addStory.setImage(story.getImage());
		addStory.setTime(LocalDateTime.now());
		addStory.setUser(user);
		storyRepository.save(addStory);
		return addStory;
	}

	@Override
	public List<Story> findStoryByUserId(Integer userId) throws Exception {
		 userRepository.findUserById(userId);
		List<Story> list = storyRepository.findByUserId(userId);
		System.out.println(list.size());
		return list;
	}

	@Override
	public Story deleteStory(Integer storyId) throws Exception {
		Story story = storyRepository.findStoryById(storyId);
		if(story == null) {
			throw new Exception("story doesnt exist");
		}
		storyRepository.delete(story);
		return story;
	}

}
