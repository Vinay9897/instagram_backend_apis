package com.social.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.social.model.Reels;

@Service
public interface ReelsRepository extends JpaRepository<Reels, Integer> {
	
	public List<Reels> findByUserId(Integer userId);

}
