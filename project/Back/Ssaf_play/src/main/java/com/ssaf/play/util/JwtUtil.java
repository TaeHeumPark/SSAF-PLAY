package com.ssaf.play.util;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


// Spring container한테 이거 대신 만들어줘~ 그럼 @Component가 필요함
@Component
public class JwtUtil {

	private static final String SALT = "SSAFIT";
	
	// 토큰 생성
	// 인자로 Map객체로 집어 넣을 수 있는데
	// 지금은 인자로 키와 벨류가 넘어왔다라고 처리(지금은 한 가지만 정보만 넣는다고 가정)
	public String createToken(String claimId, String data) throws UnsupportedEncodingException {
		// 테스트하는 데 잠시 방해가 되는 유효 기간은 지웠음
				return Jwts.builder()
				// 내가 지금 헤더라는 클래스를 만들어서 추가할 수도 있고
				// 맵 객체를 만들어서 할 수도 있고
				// 하나하나 만들면서 할 수도..
				.setHeaderParam("alg", "HS256").setHeaderParam("typ", "JWT") // 헤더 끝
				.claim(claimId, data)
				// 서명(signWith) // 위에서 HS256방식으로 하겠다 했고
				.signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8")) // 서명완료
				// String으로 반환
				.compact();
	}

	// 유효성 검사
	public void valid(String token) throws Exception {
		Jwts.parser().setSigningKey("SSAFIT".getBytes("UTF-8")).parseClaimsJws(token);
	}
}
