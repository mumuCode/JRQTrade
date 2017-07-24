package com.ch.jrq.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.jrq.domain.User;
import com.ch.jrq.service.UserService;
import com.ch.jrq.utils.StatusJSON;
import com.ch.wechat.controller.WetChatController;
@Controller
@RequestMapping("login/")
public class LoginController {
	
	private  static  final Logger logger = LoggerFactory.getLogger(WetChatController. class);
	
	@Autowired
    private UserService userServiceImpl;
	
	@RequestMapping("login")
	public String login(){
		return "login/login";
	}	
    
	@RequestMapping("checkLogin")
	@ResponseBody
	public StatusJSON checkLogin(HttpServletRequest request,
			@RequestParam(value = "username", required = true) String  username,
			@RequestParam(value = "password", required = true) String  password){
		StatusJSON statusJSON = new StatusJSON();		
		logger.info("用户登录###"+ "用户名:"+username+" 密码:"+password);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", username);
		map.put("password", password);
		map.put("status", "01");//00 无效 01 有效
		List<User> userList =  userServiceImpl.queryUserInfo(map);
		if(userList != null && userList.size() > 0){
			//登陆
			userServiceImpl.login(userList.get(0),request);
		}else{
			statusJSON.setStatus(1);
			statusJSON.setMessage("用户名或密码不正确");
			return statusJSON;
		}
				
		statusJSON.setStatus(0);
		statusJSON.setMessage("登录成功");		
		return statusJSON;
	}
	
	
	@RequestMapping(value = "exit")
    public String exit(HttpServletRequest request){
        // 登出，删除session
		userServiceImpl.loginout(request);
        // 跳转到登录页
        return "login/login";
    }
	
}
