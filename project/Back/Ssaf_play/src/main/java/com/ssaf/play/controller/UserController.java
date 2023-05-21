package com.ssaf.play.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssaf.play.dto.User;
import com.ssaf.play.service.UserService;
import com.ssaf.play.util.JwtUtil;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api-user")
public class UserController {

	@Autowired
	private JwtUtil jwtUtil;

	private static final String SUCCESS = "succes";
	private static final String FAIL = "fail";

	@Autowired
	private UserService userService;

	// 회원가입을 해보자
	@PostMapping("/regist")
	public ResponseEntity<?> signup(@RequestBody User user) {
		userService.regist(user);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

//	// 로그인 (실제 수행)
//	@PostMapping("/login")
//	public ResponseEntity<?> login(@ModelAttribute User user, HttpSession session) {
//
//		List<Map<String, Object>> list = new ArrayList<>();
//		Map<String, Object> result = new HashMap<String, Object>();
//		// Vue -> axios를 통해서 user라고 하는 데이터가 들어올 거임
//		// user를 이용해서 Service -> Dao -> DB를 통해 실제 유저인지 확인을 해야한다.
//		// 지금은 간단하게 돌아가는 것만 확인
//		HttpStatus status = null;
//
//		User tmp = userService.logIn(user.getId());
//		if (tmp == null || !(tmp.getPw().equals(user.getPw()))) {
////			System.out.println("아이디, 비밀번호가 달라요");
//			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
//		}
//		
//		try {
//			// 아이디가 널이 아니거나 길이가 있거나
//			if (user.getId() != null || user.getId().length() > 0) {
//				// 그럼 로그인
//				result.put("access-token", jwtUtil.createToken("id", user.getId()));
//				result.put("message", SUCCESS);
//				status = HttpStatus.ACCEPTED;
//			} else {
//				result.put("message", FAIL);
//				status = HttpStatus.NO_CONTENT;
//			}
//		} catch (Exception e) {
//			result.put("message", FAIL);
//			status = HttpStatus.INTERNAL_SERVER_ERROR;
//		}
//		
//		// vue에서 사용할 작성자(현재 로그인 된 사용자 이름도 같이 보내줌)
//		result.put("name", tmp.getName());
//
//		return new ResponseEntity<Map<String, Object>>(result, status);
//	}
////	public ResponseEntity<?> login(@ModelAttribute User user, HttpSession session) {
////		User tmp = userService.logIn(user.getId());
////		if(tmp == null || !(tmp.getPw().equals(user.getPw())))
////			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
////		session.setAttribute("loginUser", tmp);
////		return new ResponseEntity<String>(tmp.getName(), HttpStatus.OK);
////	}
//
//	// 로그아웃
//	@GetMapping("logout")
//	public ResponseEntity<Void> logout(HttpSession session) {
//		if (session.getAttribute("loginUser") == null)
//			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//		session.invalidate();
//
//		// 로그인 페이지로 날리던지, 목록 페이지로 날리던지...
//		return new ResponseEntity<Void>(HttpStatus.OK);
//	}

}