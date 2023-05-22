package com.ssaf.play.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssaf.play.dto.User;
import com.ssaf.play.service.AdminService;

@RestController
@RequestMapping("/api-admin/")
public class AdminController {
	
	@Autowired
	private AdminService aservice;
	
	// 유저 리스트 불러오기
	@GetMapping("userList")
	public ResponseEntity<?> userList(){
		List<User> list = aservice.selectAllUser();
		
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
}
