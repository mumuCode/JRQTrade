package com.ch.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.annotation.Log;
import com.ch.utils.StatusJSON;
@Controller
@RequestMapping("login/")
public class LoginController {
	
	@RequestMapping("login")
	public String login(){
		return "login/login";
	}	
    
	@RequestMapping("checkLogin")
	@ResponseBody
	public StatusJSON checkLogin(HttpSession session,
			@RequestParam(value = "username", required = true) String  username,
			@RequestParam(value = "password", required = true) String  password){
		StatusJSON statusJSON = new StatusJSON();
		
		System.out.println("用户登录 "+ "用户名:"+username+" 密码:"+password);
		
		statusJSON.setStatus(0);
		statusJSON.setMessage("登录成功");
		
		return statusJSON;
	}
	
	
}
