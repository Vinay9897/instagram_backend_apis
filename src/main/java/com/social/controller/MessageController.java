package com.social.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.model.Message;
import com.social.model.User;
import com.social.service.MessageService;
import com.social.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MessageController {

	@Autowired
	UserService userService;
	
	@Autowired
	MessageService messageService; 
	
	@PostMapping("/add/message/{chatId}")
	public Message addMessage(@RequestHeader("Authorization") String jwt, @PathVariable Integer chatId, @RequestBody Message mess) throws Exception
	{
		User user = userService.findUserByJwt(jwt);
		
		Message message = messageService.addMessage(user, chatId, mess);
		return message;
	}
	
	
	@GetMapping("/find/chats/{chatId}")
	public List<Message> findChatsMessage(@PathVariable Integer chatId ) throws Exception {
		
		List<Message> chats = messageService.findChatsMessage(chatId);
	
		return chats;
	}
	
	@GetMapping("/find/all/messages")
	public List<Message> findAllMessage(){
		List<Message> message = messageService.findAllMessage();
		return message;
	}
	
	@DeleteMapping("/delete/message/{messageId}")
	public Message deleteMessages(@PathVariable Integer messageId) {
		
		Message message = messageService.deleteMessage(messageId);
		return message;
	}
}
