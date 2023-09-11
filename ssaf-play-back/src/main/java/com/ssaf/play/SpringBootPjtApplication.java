package com.ssaf.play;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssaf.play.Interceptor.JwtInterceptor;
import com.ssaf.play.Interceptor.SessionInterceptor;

@SpringBootApplication
public class SpringBootPjtApplication implements WebMvcConfigurer{
	
	@Autowired
	SessionInterceptor si;
	
	/**
	 * interceptor를 등록한다. <inteceptors> 태그의 내용을 대체한다.
	 */
	
	@Autowired
	private JwtInterceptor jwtInterceptor;
		
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(si).addPathPatterns("/regist");
		registry.addInterceptor(jwtInterceptor)
		// 어떤 걸 통과시키고 뭘 짜를 건지
		// 모두 짤라
		.addPathPatterns("/**")
		// 근데 이건 봐줘
		.excludePathPatterns("/api/login",
				"/swagger-resources/**",
				"/swagger-ui/**",
				"/v2/api-docs");
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringBootPjtApplication.class, args);
	}

}
