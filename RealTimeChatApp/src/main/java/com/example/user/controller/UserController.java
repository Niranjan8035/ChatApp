package com.example.user.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.entity.User;
import com.example.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private static Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user) {

		logger.info("Inside register User");
		String response = null;
		try {
			logger.info("User:" + user);
			response = userService.register(user);

		} catch (Exception e) {
			logger.error("Error! Failed To Register User", e);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
