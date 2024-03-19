package com.social.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.social.model.Story;


public interface StoryRepository extends JpaRepository<Story, Integer>{
	
	public List<Story> findByUserId(Integer userId);
	
	public Story findStoryById(Integer storyId);
}
