package com.social.controller;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.model.Chat;
import com.social.model.User;

@RestController
@RequestMapping("/api")
public class ChatController {
	
	public Chat addChat(@RequestHeader("Authorization") String jwt, User user2)
	{
		
		return null;
	}

}
