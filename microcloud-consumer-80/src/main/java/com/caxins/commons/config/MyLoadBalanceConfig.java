package com.caxins.commons.config;

import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

public class MyLoadBalanceConfig {
	@Bean
	public IRule ribbonRule() {        // 其中IRule就是所有规则的标准
		return new RandomRule();      // 随机的访问策略
	}
}
