package com.ch.jrq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.jrq.annotation.Log;
import com.ch.jrq.service.UserService;



@Controller
@RequestMapping("userController")
public class UserController {

    @Autowired
    private UserService userService;
    
    @RequestMapping("testAOP")
    @Log(operationType="add操作:",operationName="添加用户")  
    public void testAOP(String userName,String password){        
        userService.addUser(userName, password);
    }
}