package com.yc.C81lkblog.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.yc.C81lkblog.bean.Article;
import com.yc.C81lkblog.dao.ArticleMapper;
import com.yc.C81lkblog.dao.CategoryMapper;

public class IndexAction {
				@Resource
				private ArticleMapper am;
				
				@Resource 
				private  CategoryMapper cm;
	

				@GetMapping (path = {"index","index.html","/"})
				//SpringMvc使用第一个 model 对象传递到 页面  model通过方式
				
				
				public String index (Model m ,@RequestParam(defaultValue = "1" )int page){ { 
					List<Article> newArticle = am.selectNewArticle();
					//将查询出的数据添加到model 对象传递到页面 model通过方法参数注入进来
					
					//将查询出的数据添加到model 中发送给页面
					//分页查询设置必须在查询方法执行前设定
					PageHelper.startPage(page,5); 
					m.addAttribute("newArticle",newArticle);
					m.addAttribute("category",cm.selectAll());
					return "index";
				}
				
				
					
					
				}
				
//				public String article(int id,Model m) {
//					m.addAttribute("article",)
//				}
}
