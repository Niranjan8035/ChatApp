package com.chat.app.realtimechatapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chat.app.realtimechatapp.Entity.Message;
import com.chat.app.realtimechatapp.Service.MessageDetailsService;


@RestController
@RequestMapping("/message-details")
public class MessageDetailsController { 
	
	@Autowired
	MessageDetailsService messageDetailsService;
	
	@MessageMapping("/message")
	@SendTo("topic/return-to")
	public Message getContent(@RequestBody Message message) {
		try
		{
			messageDetailsService.saveMessages(message);
            //return ResponseEntity.ok("Customer created successfully");
			Thread.sleep(1000);
			
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		return message;
	
	
				
		
	}
		
	
	

}
