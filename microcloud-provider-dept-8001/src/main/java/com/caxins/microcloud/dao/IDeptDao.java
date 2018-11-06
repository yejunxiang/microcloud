package com.caxins.microcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.caxins.vo.Dept;

@Mapper
public interface IDeptDao {
	public boolean doCreate(Dept vo);
	public Dept findById(long id);
	public List<Dept> findAll();
}
