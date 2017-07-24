package com.ch.jrq.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ch.jrq.service.UserService;
import com.ch.jrq.service.impl.UserServiceImpl;

public class LoginFilter extends OncePerRequestFilter {

	static final Logger logger = LoggerFactory.getLogger(OncePerRequestFilter.class);
	
	private String unFilter;
	
    public String getUnFilter() {
		return unFilter;
	}

	public void setUnFilter(String unFilter) {
		this.unFilter = unFilter;
	}

	@Autowired
    private UserService userServiceImpl;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String url = request.getServletPath() + (request.getPathInfo() == null ? "" : request.getPathInfo());
		boolean flag = false;		
		logger.info("LoginFilter###begin###请求地址:" + url);
		
		if(unFilter != null && unCheckUrlContains(unFilter.split(","),url)){
			//不拦截的请求，直接放行
			flag = true;
		}else{
			flag = userServiceImpl.checkLogin(request);//是否登陆
		}
		
		if(flag == false){
			 response.sendRedirect("/login/login");
             return;
		}
		
		filterChain.doFilter(request, response);
	}
	
	/**
	 * 判断是否Url是否在不校验中的
	 * @param urls
	 * @param url
	 * @return
	 */
	public static boolean unCheckUrlContains(String[] urls,String url){
		for(String tempUrl:urls){
			if(url.contains(tempUrl)){
				return true;
			}
		}
		return false;
	}

}
