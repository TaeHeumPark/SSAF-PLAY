package com.ssaf.play.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssaf.play.dao.MatchDao;
import com.ssaf.play.dto.Match;

@Service
public class MatchServiceImpl implements MatchService{
	
	@Autowired
	MatchDao dao;

	@Override
	public void regist(Match match) {
		dao.regist(match);
	}

	@Override
	public List<Match> selectSprotsMatchBoard(int sports_id) {
		return dao.selectSprotsMatchBoard(sports_id);
	}

}
