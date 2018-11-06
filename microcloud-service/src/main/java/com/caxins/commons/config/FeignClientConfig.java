package com.caxins.commons.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
@Configuration
public class FeignClientConfig {
	@Bean
	public Logger.Level getFeignLoggerLevel(){
		return feign.Logger.Level.FULL;
	}
	/**
	 * 调用微服务时授权
	 * @return
	 */
	@Bean
	public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor(){
		return new BasicAuthRequestInterceptor("zdmin", "caxinsjava");
	}
}
