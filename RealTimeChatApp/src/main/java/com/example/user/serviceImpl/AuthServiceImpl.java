package com.example.user.serviceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.entity.User;
import com.example.user.repository.UserRepo;
import com.example.user.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	private static Logger logger = LogManager.getLogger(AuthServiceImpl.class);

	@Autowired
	UserRepo userRepo;

	@Override
	public String authenticate(String username, String password) {
		logger.info("Inside authentication");

		String response = null;
		try {
			User userdetail = userRepo.findByUsernameAndPassword(username, password);

			if (userdetail != null) {
				response = "Login Successful";
			}
		} catch (Exception e) {
			logger.error("Error! while login user", e);
		}
		return response;
	}

}
