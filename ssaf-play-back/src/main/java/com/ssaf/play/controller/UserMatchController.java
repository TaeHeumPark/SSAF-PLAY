package com.ssaf.play.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssaf.play.dto.UserMatch;
import com.ssaf.play.service.UserMatchService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api-match/")
public class UserMatchController {
	
	@Autowired
	private UserMatchService userMatchService;

	// 경기에 유저 추가
	@PostMapping("regist")
	public ResponseEntity<?> regist(@RequestBody UserMatch userMatch) {

		userMatchService.regist(userMatch);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// match 정보 불러오기(이거 여기서 하지 말고 matchBoardController에서 detail들어가는 순간 해야할 듯)
	@GetMapping("{match_id}")
	public ResponseEntity<?> selectMatchInfo(@PathVariable int match_id) {

		List<UserMatch> list = userMatchService.selectAll(match_id);

		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UserMatch>>(list, HttpStatus.OK);
	}

	// 경기에 내 정보 빼기 (경기 참여 취소)
	@PostMapping("cancel")
	public ResponseEntity<Integer> cancelUserMatch(@RequestBody UserMatch userMatch) {
		int result = userMatchService.cancelUserMatch(userMatch);
		// 삭제가 됐으면 result = 1
		if (result <= 0) {
			// NO_CONTENT?
			return new ResponseEntity<Integer>(result, HttpStatus.NO_CONTENT);
		}
		// 통과 했으면 값 1 넘겨주기, OK
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

}