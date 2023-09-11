package com.ssaf.play.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssaf.play.util.JwtUtil;


@Component
public class JwtInterceptor implements HandlerInterceptor {
	private static final String HEADER_AUTH = "access-token";
	
	@Autowired
	private JwtUtil jwtutil;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 옵션이라 하는 것이 있음..
		if(request.getMethod().equals("OPTIONS"))
			return true;
		
		// access-token에 헤더라는 애 가져와
		String token = request.getHeader(HEADER_AUTH);
		
		// token이 들어있으면
		if(token != null) {
			jwtutil.valid(token);
			return true; // 진행시켜
		}
		
		return true;
//		throw new Exception("유효하지 않는 접근이다.");
		
	}
}
