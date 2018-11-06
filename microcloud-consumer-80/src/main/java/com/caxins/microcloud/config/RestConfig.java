package com.caxins.microcloud.config;

import java.nio.charset.Charset;
import java.util.Base64;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {
	@Bean
	@LoadBalanced
	public RestTemplate getRestTimplate(){
		return new RestTemplate();
	}
	@Bean
	public HttpHeaders getHeaders(){   // 进行Http头信息配置
		HttpHeaders headers = new HttpHeaders();   // 定义一个Http的头信息
		String auth = "nevergiveup:never";  // 配置原始认证信息
		// 加密处理
		byte[] encodeAuth = 
				Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
		// 在进行授权的头信息内容配置的时候加密的信息一定要与"Basic"之间有一个空格
		String anthHeader = "Basic "+new String(encodeAuth);
		headers.set("Authorization", anthHeader);
		return headers;
	}
}
