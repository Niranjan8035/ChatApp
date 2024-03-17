package com.chat.app.realtimechatapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chat.app.realtimechatapp.Entity.Message;

@Repository
public interface MessageDetailsRepo extends JpaRepository<Message, Long>{
	
	//Message findByusernameOrid(long id, String username);

}
