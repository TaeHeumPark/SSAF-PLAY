package com.ssaf.play.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ssaf.play.dao")
public class DBConfig {
	
}
