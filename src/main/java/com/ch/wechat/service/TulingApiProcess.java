package com.ch.wechat.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/** 
 * 调用图灵机器人api接口，获取智能回复内容 
 * @author pamchen-1 
 * 
 */ 
public class TulingApiProcess {
	
	private  static  final Logger logger = LoggerFactory.getLogger(TulingApiProcess. class);
	
	private int connectTimeout = 20;// 单位秒
	private int readTimeout = 20;// 单位秒
	
	/** 
     * 调用图灵机器人api接口，获取智能回复内容，解析获取自己所需结果 
     * @param content 
     * @return 
     */  
    public String getTulingResult(String content){  
        /** 此处为图灵api接口，参数key需要自己去注册申请*/  
        String apiUrl = "http://www.tuling123.com/openapi/api?key=a8567b45aa3c43b9ae8899043883fa10&info=";  
        String param = "";  
        try {  
            param = apiUrl+URLEncoder.encode(content,"utf-8");  
        } catch (UnsupportedEncodingException e1) {  
            // TODO Auto-generated catch block  
            e1.printStackTrace();  
        } //将参数转为url编码  
          
        /** 发送httpget请求 */  
        HttpClient httpclient = new HttpClient();
        // 配置读超时时间
     	httpclient.getHttpConnectionManager().getParams().setSoTimeout(readTimeout * 1000);
     	// 配置连接超时时间
     	httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(connectTimeout * 1000);
        String result = "";  
        try {  
        	HttpMethod method = new GetMethod(param);  
        	int statusCode = httpclient.executeMethod(method);
    		logger.info("http返回码：" + statusCode);
    		// 读取返回
    		if (statusCode == HttpStatus.SC_OK) {
    			result = method.getResponseBodyAsString();
    		} else {
    			String statusText = method.getStatusText();
    			throw new Exception("statusCode=" + statusCode + ", statusText="
    					+ statusText);
    		} 
    		
    		if (method != null) {
    			try {
    				method.releaseConnection();
    			} finally {
    				method = null;
    			}
    		}
    		if (httpclient != null) {
    			try {
    				httpclient.getHttpConnectionManager().closeIdleConnections(0);
    			} finally {
    				httpclient = null;
    			}
    		}
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        
        /** 请求失败处理 */  
        if(null==result){  
            return "对不起，你说的话真是太高深了……";  
        }  
          
        try {  
            JSONObject json = JSONObject.fromObject(result);  
            //以code=100000为例，参考图灵机器人api文档  
            if(100000==json.getInt("code")){  
                result = json.getString("text");  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return result;  
    }  
}
