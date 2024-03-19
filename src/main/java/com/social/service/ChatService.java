package com.social.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.social.model.Chat;
import com.social.model.User;

@Service
public interface ChatService {

	public Chat createChat(User reqUser, User user2 );
	
	public Chat findChatById(Integer chatId) throws Exception;
	
	public List<Chat> findUsersChat(Integer userdId);
	
}
