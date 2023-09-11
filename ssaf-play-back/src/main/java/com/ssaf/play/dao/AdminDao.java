package com.ssaf.play.dao;

import java.util.List;

import com.ssaf.play.dto.User;

public interface AdminDao {
	
	// 유저 리스트 불러오기
	public List<User> selectAllUser();
}
