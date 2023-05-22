package com.ssaf.play.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssaf.play.dto.Match;
import com.ssaf.play.service.MatchService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("api-match/board/")
public class MatchBoardController {
	
	
	@Autowired
	private MatchService matchService;
	
	// 경기 등록
	@PostMapping("/regist")
	public ResponseEntity<?> regist(@RequestBody Match match) {
		
		// 받아온 데이터(종목)가 축구면 1, 아니면 2(농구)
		if (match.getSport().equals("축구")) {
			match.setSports_id(1);
		} else {
			match.setSports_id(2);
		}
		
		matchService.regist(match);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
