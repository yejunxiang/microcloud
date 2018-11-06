package com.caxins.microcloud.rest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.caxins.microcloud.service.IDeptService;
import com.caxins.vo.Dept;


@RestController
public class DeptRest {
	@Resource
	private IDeptService deptService;
	@Resource
	private DiscoveryClient client;
	
	@RequestMapping("/dept/discover")
	public Object discover(HttpServletRequest request){
		return this.client;
	}
	
	@RequestMapping("/dept/sessionId")
	public Object getSessionId(HttpServletRequest request){
		return request.getSession().getId();
	}
	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	public Object getDept(@PathVariable("id") long id){
		return deptService.getDept(id);
	}
	@RequestMapping(value="/dept/add",method=RequestMethod.GET)
	public Object addDept(@RequestBody Dept dept){
		return deptService.addDept(dept);
	}
	@RequestMapping(value="/dept/list",method=RequestMethod.GET)
	public Object getList(){
		return deptService.getList();
	}
}
