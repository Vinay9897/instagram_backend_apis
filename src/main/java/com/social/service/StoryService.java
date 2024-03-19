package com.social.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.social.model.Story;

@Service
public interface StoryService {
	
	public Story createStory(Story story, Integer userId) throws Exception;
	
	public List<Story> findStoryByUserId(Integer userId) throws Exception;
	
	public Story deleteStory(Integer userId) throws Exception;

}
