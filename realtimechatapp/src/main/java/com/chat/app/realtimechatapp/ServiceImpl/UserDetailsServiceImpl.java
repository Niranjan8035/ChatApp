package com.chat.app.realtimechatapp.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.chat.app.realtimechatapp.Entity.User;
import com.chat.app.realtimechatapp.Repository.UserDetailsRepo;
import com.chat.app.realtimechatapp.Service.UserDetailsService;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserDetailsRepo userDetailsRepo;

	@Override
	public boolean saveUserData(User userinfo) {
		User user = userDetailsRepo.findByusername(userinfo.getUsername());
		if (user != null) {
			return false;
		}
		userDetailsRepo.save(userinfo);
		return true;

	}

}
