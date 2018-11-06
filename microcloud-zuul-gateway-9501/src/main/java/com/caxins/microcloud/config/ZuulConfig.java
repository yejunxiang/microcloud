package com.caxins.microcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.caxins.microcloud.filter.AuthorizedRequestFilter;
@Configuration
public class ZuulConfig {   // 创立一个配置程序列作为认证处理请求的配置Bean
	@Bean
	public AuthorizedRequestFilter getAuthorizedRequestFilter() {
		return new AuthorizedRequestFilter();
	}
	
}
