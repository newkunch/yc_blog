package com.yc.C81lkblog.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.C81lkblog.bean.Result;
import com.yc.C81lkblog.bean.User;
import com.yc.C81lkblog.biz.BizException;
import com.yc.C81lkblog.biz.UserBiz;

@RestController
public class UserAction {
			
	@Resource
	private UserBiz ub;
	
	@RequestMapping("login")	
	public Result login(@Valid User user,Errors errors,HttpSession session) {
				//用户输入的验证
				if(errors.hasFieldErrors("account") || errors.hasFieldErrors("pwd")) {
					return new Result(0,"字段验证错误",errors.getAllErrors());
				}
				
				
				//业务逻辑的验证
				try {
					User dbuser = ub.login(user);
					session.setAttribute("loginedUser", dbuser);
					return new Result(1,"登陆成功");
				} catch (BizException e) {
					e.printStackTrace();
					errors.rejectValue("account", "AccountOrPwdFailure",e.getMessage());
					return new Result(0,"业务逻辑验证错误",errors.getAllErrors());
					// TODO: handle exception
				}
				
			
			}
			
			public void register() {
						
			}
	
		
	
}
