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

import com.social.model.Chat;
import com.social.model.User;
import com.social.repositories.ChatRepository;
import com.social.response.CreateChatRequest;
import com.social.service.ChatService;
import com.social.service.UserService;

@RestController
@RequestMapping("/api")
public class ChatController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ChatService chatService;
	
	@Autowired
	ChatRepository chatRepository;
	
	@PostMapping("/chat/users")
	public Chat addChat(@RequestHeader("Authorization") String jwt,@RequestBody CreateChatRequest req) throws Exception
	{
		User reqUser = userService.findUserByJwt(jwt);
		User user2 = userService.findUserById(req.getUserId());
		System.out.println(reqUser + " " + user2);
		
		Chat chat = chatService.createChat(reqUser, user2);
		return chat;
	}
	
	@GetMapping("/find/users/chat")
	public List<Chat> findUsersChat(@RequestHeader("Authorization") String jwt, @RequestBody CreateChatRequest req)
	{
		User user = userService.findUserByJwt(jwt);
		List<Chat> chat = chatService.findUsersChat(user.getId());
		return chat;
	}
	
	@DeleteMapping("/delete/chat/{chatId}")
	public Chat deleteChat(@PathVariable Integer chatId) throws Exception
	{
		Chat chat = chatService.findChatById(chatId);
		
		if(chat == null)
			throw new Exception("chat doesn't exist");
		
		chatRepository.delete(chat);
		return chat;
	}
	
	@GetMapping("/find/all/chats")
	public List<Chat> findAllChat()
	{
		
		List<Chat> chat = chatService.findAllChat();
		return chat;
	}

}
