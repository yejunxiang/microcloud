package com.caxins.microcloud.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.caxins.vo.Dept;

@RestController
public class ConsumerDeptController {
	public static final String DEPT_GET_URL = "http://MICROCLOUD-PROVIDER-DEPT/dept/get/";
	public static final String DEPT_LIST_URL = "http://MICROCLOUD-PROVIDER-DEPT/dept/list/";
	public static final String DEPT_ADD_URL = "http://MICROCLOUD-PROVIDER-DEPT/dept/add/";
	@Resource
	private RestTemplate restTemplate;
	@Resource
	private HttpHeaders headers;
	@Resource
	private LoadBalancerClient loadBalancerClient;
	@RequestMapping(value="/consumer/dept/get")
	public Object getDept(long id){
		ServiceInstance serviceInstance =
				this.loadBalancerClient.choose("MICROCLOUD-PROVIDER-DEPT");
		System.out.println("【***ServiceInstance***】host = "+serviceInstance.getHost()
								+",port = "+serviceInstance.getPort()
								+",serviceId = "+serviceInstance.getServiceId());
		Dept dept = restTemplate.exchange(DEPT_GET_URL+id, HttpMethod.GET,
				new HttpEntity<Object>(headers),Dept.class).getBody();
		return dept;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/consumer/dept/list")
	public Object listDept(){
		List<Dept> deptList = restTemplate.exchange(DEPT_LIST_URL,
				HttpMethod.GET,new HttpEntity<Object>(headers),List.class).getBody();
		return deptList;
	}
	@RequestMapping(value="/consumer/dept/add")
	public Object addDept(Dept dept){
		Boolean flag = restTemplate.exchange(DEPT_ADD_URL,HttpMethod.POST,
				new HttpEntity<Object>(dept,headers),Boolean.class).getBody();
		return flag;
	}
}
