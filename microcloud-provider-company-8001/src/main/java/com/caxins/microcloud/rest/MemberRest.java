package com.caxins.microcloud.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.caxins.vo.Company;



@RestController
public class MemberRest {
	@RequestMapping(value="/company/get/{title}",method=RequestMethod.GET)
	public Object get(@PathVariable("title") String title){
		Company vo = new Company();
		vo.setTitle(title);
		vo.setNote("www.caxins.com");
		return vo;
	}
}
