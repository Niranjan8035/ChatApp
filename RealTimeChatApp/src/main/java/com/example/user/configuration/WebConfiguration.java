package com.example.user.configuration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.example.user.serviceImpl.WebSocketServer;

@Configuration
public class WebConfiguration {

	@Autowired
	WebSocketServer socketServer;

	@PostConstruct
	public void createSocket() {
		socketServer.setPort(8082);
		socketServer.start();
	}

}
