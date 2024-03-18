package com.example.user.serviceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.controller.UserController;
import com.example.user.entity.User;
import com.example.user.repository.UserRepo;
import com.example.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static Logger logger = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepo userRepo;

	@Override
	public String register(User user) {
		logger.info("Inside register");

		String response = "Failed To Register User";

		try {

			User userdetail = userRepo.findByUsername(user.getUsername());

			if (userdetail.getUsername().equalsIgnoreCase(user.getUsername())) {
				response = "User Already Registered";
			} else {
				userRepo.save(user);
				response = "User Registered";
			}
		} catch (Exception e) {
			logger.error("Error! while register user", e);
		}
		return response;

	}

}
