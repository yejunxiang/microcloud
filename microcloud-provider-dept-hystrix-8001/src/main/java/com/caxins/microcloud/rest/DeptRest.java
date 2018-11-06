package com.caxins.microcloud.rest;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.caxins.microcloud.service.IDeptService;
import com.caxins.vo.Dept;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@RestController
public class DeptRest {
	@Resource
	private IDeptService deptService;
	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod="getFallback")    // 如果当前调用的get()方法出现了错误，则返回fallback
	public Object get(@PathVariable("id") long id){
		Dept vo = deptService.getDept(id);
		if (vo == null) {
			throw new RuntimeException();
		}
		return vo;
	}
	
	public Object getFallback(@PathVariable("id") long id){    // 此时的方法参数与上面的get()一致
		Dept vo = new Dept();
		vo.setDeptno(999999L);
		vo.setDname("【ERROR】Microcloud-Dept-Hystrix");    // 错误的提示
		vo.setLoc("DEPT-Provider");
		return vo;
	}
}
