package com.ssaf.play.service;

import java.util.List;

import com.ssaf.play.dto.UserMatch;

public interface UserMatchService {
	
	// UserMatch 등록
	public void regist(UserMatch userMatch);
	
	// 현재 클릭한 match_id로 정보 불러오기(이 경기에 매칭된 유저, 그 유저의 포지션, 팀 - 1팀인지 2팀인지)
	public List<UserMatch> selectAll(int match_id);
	
	// 경기에 현재 로그인 된 유저 취소하기
	public int cancelUserMatch(UserMatch userMatch);
}
