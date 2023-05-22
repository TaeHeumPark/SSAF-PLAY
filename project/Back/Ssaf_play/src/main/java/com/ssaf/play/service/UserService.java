package com.ssaf.play.service;

import com.ssaf.play.dto.User;

public interface UserService {
	// 회원가입
	public void regist(User user);

	// id를 보내서 같은지 확인
	public User logIn(String email);
}
