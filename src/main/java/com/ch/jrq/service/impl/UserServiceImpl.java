package com.ch.jrq.service.impl;

import org.springframework.stereotype.Service;

import com.ch.jrq.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Override
	public void addUser(String userName, String password) {
		System.err.println("-----------addUser-----userName: "+userName+"\tpassWord: " +password);
		
	}

}
