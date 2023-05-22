package com.ssaf.play.dao;

import com.ssaf.play.dto.User;

public interface UserDao {
	// 회원가입
	public void regist(User user);
	
	// login
	public User logIn(String email);
}
