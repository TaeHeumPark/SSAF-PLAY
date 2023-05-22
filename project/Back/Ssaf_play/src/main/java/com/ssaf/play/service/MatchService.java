package com.ssaf.play.service;

import java.util.List;

import com.ssaf.play.dto.Match;

public interface MatchService {
	
	// 매치 게시글 등록
	public void regist(Match match);
	
	// 매치 게시글 불러오기(스포츠 별로)
	public List<Match> selectSprotsMatchBoard(int sports_id);
	
	// 매치 게시글 상세 보기
	public Match detailMatchBoard(int match_id);
	
	// 매치 게시글 업데이트
	public int updateMatch(Match match);
	
	// 매치 게시글 삭제
	public int deleteMatch(int match_id);
}
