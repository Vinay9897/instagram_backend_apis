package com.social.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.social.model.Message;
import com.social.model.User;

@Service
public interface MessageService {

	public Message addMessage(User user, Integer chatId, Message chat) throws Exception;

	public Message deleteMessage(Integer chatId);

	public List<Message> findChatsMessage(Integer chatId) throws Exception;

	public List<Message> findAllMessage();

	public Message updateMessage(Integer chatId);

}
