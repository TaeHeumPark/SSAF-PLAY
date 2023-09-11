package com.ssaf.play.dao;

import java.util.List;

import com.ssaf.play.dto.UserMatch;

public interface UserMatchDao {
	
	// 등록
	public void regist(UserMatch userMatch);

	// 매칭 정보
	public List<UserMatch> selectAll(int match_id);

	// 매칭 유저 취소
	public int cancelUserMatch(UserMatch userMatch);
	
}
