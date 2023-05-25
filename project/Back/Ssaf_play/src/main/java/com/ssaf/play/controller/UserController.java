package com.ssaf.play.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

	@Autowired
	ResourceLoader resLoader;

	// 회원가입을 해보자
	@PostMapping("/regist")
	public ResponseEntity<?> regist(@RequestBody User user) {

		// 선호 포지션이 없다면 8(free position으로 default값 설정)
		if (user.getPreferred_position() == 0) {
			user.setPreferred_position(8);
		}
		MultipartFile file = (MultipartFile) user.getProfile_img();

		try {

			if (file != null && file.getSize() > 0) {
				// 파일을 저장할 위치 지정
				Resource res = resLoader.getResource("classpath:static/resources/upload/");
				
				// 파일 중복 방지를 위해 시간을 file_name에 추가
				user.setFile_name(System.currentTimeMillis() + "_" + file.getOriginalFilename());

				file.transferTo(new File(res.getURL().getPath() + user.getFile_name()));
			}
			// 프로필 이미지가 없으면 기본 이미지 설정 해줄 건지?
			userService.regist(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 로그인 (실제 수행)
	@PostMapping("/login")
	public ResponseEntity<?> login(@ModelAttribute User user, HttpSession session) {

		Map<String, Object> result = new HashMap<String, Object>();
		// Vue -> axios를 통해서 user라고 하는 데이터가 들어올 거임
		HttpStatus status = null;

		User tmp = userService.logIn(user.getEmail());
		if (tmp == null || !(tmp.getPassword().equals(user.getPassword()))) {
//			System.out.println("아이디, 비밀번호가 달라요");
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}

		try {
			// 아이디가 널이 아니거나 길이가 있거나
			if (user.getEmail() != null || user.getEmail().length() > 0) {
				// 그럼 로그인
				result.put("access-token", jwtUtil.createToken("email", user.getEmail()));
				result.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				result.put("message", FAIL);
				status = HttpStatus.NO_CONTENT;
			}
		} catch (Exception e) {
			result.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		// vue에서 사용할 작성자(현재 로그인 된 사용자 이름도 같이 보내줌)
		result.put("name", tmp.getName());

		// 지금은 확인차 세션 set - back 단에서 session 사용 안 할 거니까 이건 test용
		session.setAttribute("loginUser", tmp);

		return new ResponseEntity<Map<String, Object>>(result, status);
	}

	// 로그아웃 이건 back이 아니라 Front에서 하는 게 나을 듯? - session이 back이랑 front랑 다름
	@GetMapping("logout")
	public ResponseEntity<Void> logout(HttpSession session) {
		if (session.getAttribute("loginUser") == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		session.invalidate();

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 내 유저 정보 불러오기(password도 불러오기 때문에 안전한 post로)
	// 세션에 저장 된 email 파라미터 값으로 가져오기
	@PostMapping("mypage/{email}")
	public ResponseEntity<?> mypage(@PathVariable String email) {
		User user = userService.myPage(email);
		System.out.println(user);
		// front에서 보낸 현재 session email이랑
		if (user.getUser_id() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	// 추가 됨
	// image보여달라 요청 보내면 image(주소) 반환
	@GetMapping("/display")
	public ResponseEntity<Resource> display(@RequestParam("filename") String filename) throws IOException {
	    Resource res = resLoader.getResource("classpath:static/resources/upload");
	    System.out.println(filename);
	    String path = res.getFile().getCanonicalPath() + "/" + filename;
	    Resource resource = new FileSystemResource(path);
	    if(!resource.exists())
	        return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
	    HttpHeaders header = new HttpHeaders();
	    Path filePath = null;
	    try{
	        filePath = Paths.get(path);
	        header.add("Content-type", Files.probeContentType(filePath));
	    }catch(IOException e) {
	        e.printStackTrace();
	    }
	    System.out.println("다통과");
	    System.out.println(resource);
	    System.out.println(header);
	    return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}

	// 마이페이지 정보 수정
	@PostMapping("mypage/update")
	public ResponseEntity<?> updateUser(User user) {
//		굳이 이렇게 안 써도 email을 Front에서 readOnly 하면 될 듯?
//		User currUser = userService.myPage(email);
//		
//		if(!(currUser.getEmail().equals(user.getEmail()))) {
//			// 비정상적 접근 차단
//			// Front에서 보내는 session의 유저와 작성한 유저 정보가 다르면 바로 리턴
//			return new ResponseEntity<Void>(HttpStatus.PRECONDITION_FAILED);
//		}

		// session의 email과 바꾸고 싶은 아이디가 맞다면
		int result = userService.updateUser(user);
		// 업데이트 못 했으면 412 에러 띄우기
		if (result == 0) {
			return new ResponseEntity<Void>(HttpStatus.PRECONDITION_FAILED);
		}

		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

	// 회원 탈퇴
	@PostMapping("mypage/delete/{email}")
	public ResponseEntity<?> deleteUser(@PathVariable String email) {

		// session의 email을 삭제
		int result = userService.deleteUser(email);
		if (result == 0) {
			return new ResponseEntity<Void>(HttpStatus.PRECONDITION_FAILED);
		}

		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

}