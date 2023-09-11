package com.ssaf.play.service;

import java.util.List;

import com.ssaf.play.dto.User;


public interface AdminService {
	
	// 유저 리스트 불러오기
	public List<User> selectAllUser();
}
