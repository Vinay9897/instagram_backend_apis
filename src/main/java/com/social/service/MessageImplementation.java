package com.social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.model.Chat;
import com.social.model.Message;
import com.social.model.User;
import com.social.repositories.MessageRepository;

@Service
public class MessageImplementation implements MessageService  {

	@Autowired
	MessageRepository messageRepository;
	
	@Autowired
	private ChatService chatService;
	
	@Override
	public Message addMessage(User user, Integer chatId, Message req) throws Exception {
		
		Message message = new Message();
		
		Chat chat = chatService.findChatById(chatId);
		message.setChat(chat);
		message.setContent(req.getContent());
		message.setImage(req.getImage());
		message.setTimestamp(req.getTimestamp());
		message.setImage(req.getImage());
		message.setUser(user);
		messageRepository.save(message);
		return message;
	}

	@Override
	public Message deleteMessage(Integer chatId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> findChatsMessage(Integer chatId) throws Exception {
		
		Chat chat = chatService.findChatById(chatId);
		if(chat == null)
			throw new Exception("chat id doesn't exist");
		List<Message> mess = messageRepository.findByChatId(chatId);
		messageRepository.saveAll(mess);
		return mess;
	}

	@Override
	public List<Message> findAllMessage() {
		
		return messageRepository.findAll();
	}

	@Override
	public Message updateMessage(Integer chatId) {
		
		return null;
	}

	

}
