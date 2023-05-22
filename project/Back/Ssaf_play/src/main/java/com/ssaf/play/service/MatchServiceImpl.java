package com.ssaf.play.service;

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

}
