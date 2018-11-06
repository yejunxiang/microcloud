package com.caxins.microcloud.service;

import java.util.List;

import com.caxins.vo.Dept;


public interface IDeptService {
	public Dept getDept(long id);
	public boolean addDept(Dept vo);
	public List<Dept> getList();
}
