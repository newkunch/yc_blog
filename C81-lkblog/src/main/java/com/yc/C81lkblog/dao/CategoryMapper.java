package com.yc.C81lkblog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.yc.C81lkblog.bean.Category;

public interface CategoryMapper {
		
	@Select("select *from category")
	public List<Category> selectAll();
	
	@Select("select *from category where id = #(id)")
	public Category selectById(int id);
}
