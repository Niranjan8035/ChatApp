package com.chat.app.realtimechatapp.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chat.app.realtimechatapp.Entity.Message;
import com.chat.app.realtimechatapp.Repository.MessageDetailsRepo;
import com.chat.app.realtimechatapp.Service.MessageDetailsService;

@Component
public class MessageDetailsServiceImpl implements MessageDetailsService{
	
	@Autowired
	MessageDetailsRepo messageDetailsRepo;

	@Override
	public void saveMessages(Message messageInfo) {
		messageDetailsRepo.save(messageInfo);
		
	}

	
	
	

}
