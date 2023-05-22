package com.ssaf.play.dao;

import java.util.List;

import com.ssaf.play.dto.Match;

public interface MatchDao {
	
	// 매치 게시글 등록
	public void regist(Match match);
	
	// 스포츠 별 매치 게시글 불러오기
	public List<Match> selectSprotsMatchBoard(int sports_id);
	
	// 게시글 상세 정보
	public Match detailMatchBoard(int match_id);
	
	// 게시글 수정
	public int updateMatch(Match match);
	
	// 게시글 삭제
	public int deleteMatch(int match_id);
}
