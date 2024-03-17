package com.chat.app.realtimechatapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chat.app.realtimechatapp.Entity.User;

public interface UserDetailsRepo extends JpaRepository<User, Long> {

	@Query("SELECT us FROM User us WHERE us.username=:username")
	User findByusername(String username);
	
}
