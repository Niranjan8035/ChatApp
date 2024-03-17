package com.chat.app.realtimechatapp.Service;

import org.springframework.stereotype.Service;



import com.chat.app.realtimechatapp.Entity.User;

@Service
public interface UserDetailsService {

	boolean saveUserData (User userinfo );
	

}
