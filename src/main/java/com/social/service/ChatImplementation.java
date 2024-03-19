package com.social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.model.Chat;
import com.social.model.User;
import com.social.repositories.ChatRepository;

@Service
public class ChatImplementation implements ChatService{
	
	@Autowired
	ChatRepository chatRepository;

	@Override
	public Chat createChat(User reqUser, User user2) {
		
		Chat chat = chatRepository.findChatByUserId(reqUser, user2);
		
		if(chat == null)
		{
			Chat chat1  = new Chat();
			chat1.getUsers().add(user2);
		}
		
		return chat;
	}

	@Override
	public Chat findChatById(Integer chatId) throws Exception {
		Chat chat = chatRepository.findById(chatId).get();
		if(chat == null)
		{
			throw new Exception("chat id doesn't exist");
		}
		return chat;
	}

	@Override
	public List<Chat> findUsersChat(Integer userdId) {
		List<Chat> list = chatRepository.findByUsersId(userId);
		return list;
	}
	
}
