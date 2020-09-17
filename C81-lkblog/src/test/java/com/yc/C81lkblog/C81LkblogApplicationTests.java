package com.yc.C81lkblog;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.yc.C81lkblog.bean.Category;
import com.yc.C81lkblog.dao.CategoryMapper;

@SpringBootTest
class C81LkblogApplicationTests {

	@Resource
	private CategoryMapper cm;
	
	
	@Test
	void contextLoads() {
		for(Category c : cm.selectAll()) {
			System.out.println(c.getName());
		}
	}

}
