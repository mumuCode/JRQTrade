package com.ch.wechat.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.wechat.service.WechatProcess;
@Controller
@RequestMapping("wechat/")
public class WetChatController {
	
	private  static  final Logger logger = LoggerFactory.getLogger(WetChatController. class);
    
	@RequestMapping("sendMessage")
	@ResponseBody
	public String sendMessage(HttpServletRequest request) throws Exception{
		logger.info("接收微信消息接口###sendMessage###Start");
		request.setCharacterEncoding("UTF-8"); 
		/** 读取接收到的xml消息 */  
        StringBuffer sb = new StringBuffer();  
        InputStream is = request.getInputStream();  
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");  
        BufferedReader br = new BufferedReader(isr);  
        String s = "";  
        while ((s = br.readLine()) != null) {  
            sb.append(s);  
        }  
        String xml = sb.toString(); //接收到微信端发送过来的xml数据  
        logger.info("接收微信消息接口###sendMessage###请求参数："+xml);
        String result = "";  
        /** 判断是否是微信接入激活验证，只有首次接入验证时才会收到echostr参数，此时需要把它直接返回 */  
        String echostr = request.getParameter("echostr");  
        if (echostr != null && echostr.length() > 1) {
        	logger.info("接收微信消息接口###sendMessage###首次接入验证参数："+echostr);
            result = echostr;  
        } else {  
            //正常的微信处理流程
            result = new WechatProcess().processWechatMag(xml);  
        }  
        logger.info("接收微信消息接口###sendMessage###End###返回参数："+result);
        return result;
	}
	
	
}
