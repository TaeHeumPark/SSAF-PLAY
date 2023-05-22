package com.ssaf.play.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssaf.play.dao.UserDao;
import com.ssaf.play.dto.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao dao;
	
	@Override
	public void regist(User user) {
		dao.regist(user);
	}

	@Override
	public User logIn(String email) {
		return dao.logIn(email);
	}

}
