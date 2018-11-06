package com.caxins.microcloud.security.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
@Configuration
@EnableWebSecurity
public class WebSecurityGlobal extends WebSecurityConfigurerAdapter {
	@Resource
	public void configGlobal(AuthenticationManagerBuilder auth) 
			throws Exception{
		auth.inMemoryAuthentication().withUser("nevergiveup").password("never").roles("USER")
		.and().withUser("admin").password("hello").roles("USER","ADMIN");
	}
	
	@Override
	public void configure(HttpSecurity security) throws Exception{
		// 表示所有的访问都必须进行认证处理后才可以正常进行
		security.httpBasic().and().authorizeRequests().anyRequest()
			.fullyAuthenticated();
		// 所有的Rest服务一定要设置为无状态，以提升操作性能
		security.sessionManagement().sessionCreationPolicy(
				SessionCreationPolicy.STATELESS);
	}
}
