package com.ssaf.play.dao;

import java.util.List;

import com.ssaf.play.dto.Match;

public interface MatchDao {
	
	// 매치 게시글 등록
	public void regist(Match match);
	
	// 스포츠 별 매치 게시글 불러오기
	public List<Match> selectSprotsMatchBoard(int sports_id);
}
