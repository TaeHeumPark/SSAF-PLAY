package com.ssaf.play.service;

import com.ssaf.play.dto.User;

public interface UserService {
	// 회원가입
	public void regist(User user);

	// email를 보내서 같은지 확인
	public User logIn(String email);
	
	// email 값으로 내 정보 가져오기
	public User myPage(String email);
	
	// 회원 정보 수정
	public int updateUser(User user);
	
	// 회원 삭제
	public int deleteUser(String email);
}
