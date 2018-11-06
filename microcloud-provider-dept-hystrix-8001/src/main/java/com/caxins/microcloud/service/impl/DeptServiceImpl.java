package com.caxins.microcloud.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caxins.microcloud.dao.IDeptDao;
import com.caxins.microcloud.service.IDeptService;
import com.caxins.vo.Dept;
@Service
public class DeptServiceImpl implements IDeptService{
	@Resource
	private IDeptDao deptDao;
	@Override
	public Dept getDept(long id) {
		return deptDao.findById(id);
	}

	@Override
	public boolean addDept(Dept vo) {
		return deptDao.doCreate(vo);
	}

	@Override
	public List<Dept> getList() {
		return deptDao.findAll();
	}

}
