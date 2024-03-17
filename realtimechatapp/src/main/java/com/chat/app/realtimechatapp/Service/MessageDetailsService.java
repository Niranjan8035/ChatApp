package com.chat.app.realtimechatapp.Service;

import org.springframework.stereotype.Service;

import com.chat.app.realtimechatapp.Entity.Message;

@Service
public interface MessageDetailsService {

	void saveMessages(Message messageInfo);

}
