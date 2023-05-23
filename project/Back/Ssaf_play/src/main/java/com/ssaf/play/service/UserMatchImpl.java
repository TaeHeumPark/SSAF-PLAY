package com.ssaf.play.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssaf.play.dao.UserMatchDao;
import com.ssaf.play.dto.UserMatch;

@Service
public class UserMatchImpl implements UserMatchService {
	
	@Autowired
	UserMatchDao dao;

	@Override
	public void regist(UserMatch userMatch) {
		dao.regist(userMatch);
	}

	@Override
	public List<UserMatch> selectAll(int match_id) {
		return dao.selectAll(match_id);
	}

	@Override
	public int cancelUserMatch(UserMatch userMatch) {
		return dao.cancelUserMatch(userMatch);
	}

}
