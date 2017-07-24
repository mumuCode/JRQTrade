package com.ch.jrq.service;

import java.util.List;
import java.util.Map;

import com.ch.jrq.domain.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

	void addUser(String userName, String password);

	boolean checkLogin(HttpServletRequest request);

	void loginout(HttpServletRequest request);

	List<User> queryUserInfo(Map<String, String> map);

	void login(User user, HttpServletRequest request);
	
	

}
