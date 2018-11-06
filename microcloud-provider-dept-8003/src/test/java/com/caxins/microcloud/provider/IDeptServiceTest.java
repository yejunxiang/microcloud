package com.caxins.microcloud.provider;

import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.druid.support.logging.Resources;
import com.caxins.microcloud.Dept_8003_StartSpringCloudApplication;
import com.caxins.microcloud.service.IDeptService;
import com.caxins.vo.Dept;

import sun.tools.tree.ThisExpression;

@SpringBootTest(classes = Dept_8003_StartSpringCloudApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class IDeptServiceTest {
	@Resource
	private IDeptService deptService;
	@Test
	public void testGetDept(){
		System.out.println(deptService.getDept(6));
	}
	
	@Test
	public void testAddDept(){ 
		Dept dept = new Dept();
		dept.setDname("测试部"+System.currentTimeMillis());
		System.out.println(deptService.addDept(dept));
	}
	
	@Test
	public void getList(){
		System.out.println(deptService.getList());
	}
}
