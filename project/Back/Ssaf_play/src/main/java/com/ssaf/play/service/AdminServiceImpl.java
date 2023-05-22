package com.ssaf.play.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssaf.play.dao.AdminDao;
import com.ssaf.play.dto.User;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao dao;
	
	@Override
	public List<User> selectAllUser() {
		return dao.selectAllUser();
	}

}
