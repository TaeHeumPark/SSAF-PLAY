package com.ssaf.play.service;

import com.ssaf.play.dto.User;

public interface UserService {
	// 회원가입
	public void regist(User user);

	// 서치유저
	public User logIn(String id);
}
