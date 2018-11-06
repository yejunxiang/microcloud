package com.caxins.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages={"com.caxins.service"})
public class Consumer_feign_StartSpringCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(Consumer_feign_StartSpringCloudApplication.class,args);
	}

}
