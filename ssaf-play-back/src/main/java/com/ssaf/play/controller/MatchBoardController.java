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

import com.ssaf.play.dto.Match;
import com.ssaf.play.dto.User;
import com.ssaf.play.dto.UserMatch;
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

	// match 게시글 불러오기 (스포츠별로)
	@GetMapping("{sport}")
	public ResponseEntity<?> partboard(@PathVariable String sport) {

		// 넘어오는 값이 축구면 1, 아니면 2
		int sports_id = 0;
		if (sport.equals("축구")) {
			sports_id = 1;
		} else {
			sports_id = 2;
		}

		List<Match> list = matchService.selectSprotsMatchBoard(sports_id);
		System.out.println(list);
		for(Match a : list) {
			System.out.println(a.toString());
		}
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Match>>(list, HttpStatus.OK);
	}

	// matchBoard 디테일
	@GetMapping("detail/{match_id}")
	public ResponseEntity<?> detailMatchBoard(@PathVariable int match_id) {
		Match match = matchService.detailMatchBoard(match_id);
		// 넘어온 매치 정보가 없으면(title로 검사)
		if (match.getTitle() == null) {
			// NO_CONTENT
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		// 통과 했으면 그 match 넘겨주기
		return new ResponseEntity<Match>(match, HttpStatus.OK);
	}

	// 매치 게시글 정보 수정
	@PostMapping("detail/update")
	public ResponseEntity<?> updateMatchBoard(Match match) {
		// 매치 게시글 작성자와 session의 아이디가 같은지 검사 = front에서

		int result = matchService.updateMatch(match);
		// 업데이트 못 했으면 412 에러 띄우기
		if (result == 0) {
			return new ResponseEntity<Void>(HttpStatus.PRECONDITION_FAILED);
		}

		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

	// 매치 게시글 삭제
	@PostMapping("detail/delete/{match_id}")
	public ResponseEntity<?> deleteMatchBoard(@PathVariable int match_id) {

		// session의 email을 삭제
		int result = matchService.deleteMatch(match_id);
		if(result == 0) {
			return new ResponseEntity<Void>(HttpStatus.PRECONDITION_FAILED);
		}

		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

}
