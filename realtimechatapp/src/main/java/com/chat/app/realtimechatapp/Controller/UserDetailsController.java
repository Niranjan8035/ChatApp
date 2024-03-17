package com.chat.app.realtimechatapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chat.app.realtimechatapp.Entity.User;
import com.chat.app.realtimechatapp.Service.UserDetailsService;

@RestController
@RequestMapping("/user-details")
public class UserDetailsController {

	@Autowired
	UserDetailsService userDetailsService;

	@PostMapping("/user-registration")
	public ResponseEntity<String> saveUserData(@RequestBody User userinfo) {

		boolean result = userDetailsService.saveUserData(userinfo);
		if (result) {
			return ResponseEntity.ok("Data Enter Successfully");
		}

		return ResponseEntity.ok("User aleready present");
	}

	
}