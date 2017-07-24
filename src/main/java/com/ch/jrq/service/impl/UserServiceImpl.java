package com.ch.jrq.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.jrq.dao.UserInfoMapper;
import com.ch.jrq.domain.User;
import com.ch.jrq.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserInfoMapper  userInfoMapper;
	
	private static String session_name = "user";

	@Override
	public void addUser(String userName, String password) {
		System.err.println("-----------addUser-----userName: "+userName+"\tpassWord: " +password);
		
	}

	 /**
     * 检测是否登录
     * @param request
     * @return
     */
    public boolean checkLogin(HttpServletRequest request) {
    	User user = (User)request.getSession().getAttribute(session_name);
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * 退出登陆
     * @param request
     * @return
     */
    public void loginout(HttpServletRequest request) {
    	request.getSession().removeAttribute(session_name);
    }

	@Override
	public List<User> queryUserInfo(Map<String, String> map) {
		return userInfoMapper.queryUserInfo(map);
	}

	/**
     * 登陆
     * @param request
     * @return
     */
	public void login(User user, HttpServletRequest request) {
		request.getSession().setAttribute(session_name, user);
	}
	
}
