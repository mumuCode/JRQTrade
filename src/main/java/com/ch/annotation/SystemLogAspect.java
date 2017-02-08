package com.ch.annotation;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ch.domain.SystemLog;
import com.ch.domain.User;
import com.ch.service.SystemLogService;
import com.ch.utils.JsonUtil;
/**
 * 切面
 * 暂不启用切面日志记录
 */
//@Aspect
//@Component
public class SystemLogAspect {
	@Autowired
	private SystemLogService systemLogService;
	 private  static  final Logger logger = LoggerFactory.getLogger(SystemLogAspect. class);  
	
		@Pointcut("execution (* com.ch.controller.*.*(..))")
		private void anyMethod() {}//声明一个切入点
		
		@Before("anyMethod() && args(name)")
		public void doAccessCheck(String name) {
			System.out.println("前置通知:"+ name);
		}
		
		@AfterReturning(pointcut="anyMethod()",returning="result")
		public void doAfterReturning(JoinPoint joinPoint) {
			 System.err.println("=====执行controller后置返回通知=====");  
             if(logger.isInfoEnabled()){
                 logger.info("afterReturn " + joinPoint);
             }
		}
		
		@After("anyMethod()")
		public void doAfter(JoinPoint joinPoint) {
			try{
			System.out.println("最终通知");
			
			User user = new User();
	        user.setId(1);
	        user.setName("张三");
	        String ip = "127.0.0.1";
	        String params = "";  
	         if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {  
	             for ( int i = 0; i < joinPoint.getArgs().length; i++) {  
	                params += JsonUtil.getJsonStr(joinPoint.getArgs()[i]) + ";";  
	            }  
	        }  
	        
	        String targetName = joinPoint.getTarget().getClass().getName();  
            String methodName = joinPoint.getSignature().getName();  
            Object[] arguments = joinPoint.getArgs();  
            Class targetClass = Class.forName(targetName);  
            Method[] methods = targetClass.getMethods();
            String operationType = "";
            String operationName = "";
             for (Method method : methods) {  
                 if (method.getName().equals(methodName)) {  
                    Class[] clazzs = method.getParameterTypes();  
                     if (clazzs.length>0&&arguments.length>0&&clazzs.length == arguments.length) {  
                         operationType = method.getAnnotation(Log.class).operationType();
                         operationName = method.getAnnotation(Log.class).operationName();
                         break;  
                    }  
                }  
            }
            //*========控制台输出=========*//  
            System.err.println("=====controller后置通知开始=====");  
            System.err.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")+"."+operationType);  
            System.err.println("方法描述:" + operationName);  
            System.err.println("请求人:" + user.getName());  
            System.err.println("请求IP:" + ip);  
            //*========数据库日志=========*//  
            SystemLog log = new SystemLog();  
            log.setId(UUID.randomUUID().toString());
            log.setDescription(operationName);  
            log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")+"."+operationType);  
            log.setLogType((long)0);  
            log.setRequestIp(ip);  
            log.setExceptioncode( null);  
            log.setExceptionDetail( null);  
            log.setParams( params);  
            log.setCreateBy(user.getName());  
            log.setCreateDate(new Date());  
            //保存数据库  
            systemLogService.insert(log);  
            System.err.println("=====controller后置通知结束=====");  
        }  catch (Exception e) {  
            //记录本地异常日志  
            logger.error("==后置通知异常==");  
            logger.error("异常信息:{}", e.getMessage());  
        }  
			
		}
		
		@AfterThrowing(pointcut="anyMethod()",throwing="e")
		public void doAfterThrowing(JoinPoint joinPoint,Exception e) {
			System.out.println("例外通知:"+ e);
			  
	        /*HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();  
	        HttpSession session = request.getSession();  
	        //读取session中的用户  
	        User user = (User) session.getAttribute(WebConstants.CURRENT_USER);  
	        //获取请求ip  
	        String ip = request.getRemoteAddr(); */ 
	        //获取用户请求方法的参数并序列化为JSON格式字符串  
	        System.err.println("-------------- 异常通知  异常通知  异常通知  异常通知 ---------------------------------");
	        User user = new User();
	        user.setId(1);
	        user.setName("张三");
	        String ip = "127.0.0.1";
	        
	        String params = "";  
	         if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {  
	             for ( int i = 0; i < joinPoint.getArgs().length; i++) {  
	                params += JsonUtil.getJsonStr(joinPoint.getArgs()[i]) + ";";  
	            }  
	        }  
	         try {  
	             
	             String targetName = joinPoint.getTarget().getClass().getName();  
	             String methodName = joinPoint.getSignature().getName();  
	             Object[] arguments = joinPoint.getArgs();  
	             Class targetClass = Class.forName(targetName);  
	             Method[] methods = targetClass.getMethods();
	             String operationType = "";
	             String operationName = "";
	              for (Method method : methods) {  
	                  if (method.getName().equals(methodName)) {  
	                     Class[] clazzs = method.getParameterTypes();  
	                      if (clazzs.length == arguments.length) {  
	                          operationType = method.getAnnotation(Log.class).operationType();
	                          operationName = method.getAnnotation(Log.class).operationName();
	                          break;  
	                     }  
	                 }  
	             }
	             /*========控制台输出=========*/  
	            System.err.println("=====异常通知开始=====");  
	            System.err.println("异常代码:" + e.getClass().getName());  
	            System.err.println("异常信息:" + e.getMessage());  
	            System.err.println("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")+"."+operationType);  
	            System.err.println("方法描述:" + operationName);  
	            System.err.println("请求人:" + user.getName());  
	            System.err.println("请求IP:" + ip);  
	            System.err.println("请求参数:" + params);  
	               /*==========数据库日志=========*/  
	            SystemLog log = new SystemLog();
	            log.setId(UUID.randomUUID().toString());
	            log.setDescription(operationName);  
	            log.setExceptioncode(e.getClass().getName());  
	            log.setLogType((long)1);  
	            log.setExceptionDetail(e.getMessage());  
	            log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));  
	            log.setParams(params);  
	            log.setCreateBy(user.getName());  
	            log.setCreateDate(new Date());  
	            log.setRequestIp(ip);  
	            //保存数据库  
	            systemLogService.insert(log);  
	            System.err.println("=====异常通知结束=====");  
	        }  catch (Exception ex) {  
	            //记录本地异常日志  
	            logger.error("==异常通知异常==");  
	            logger.error("异常信息:{}", ex.getMessage());  
	        }  
	         /*==========记录本地异常日志==========*/  
	        logger.error("异常方法:{}异常代码:{}异常信息:{}参数:{}", joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName(), e.getClass().getName(), e.getMessage(), params);  
	  
	    
		}
		
		@Around("anyMethod()")
		public void doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		    System.err.println("==========开始执行controller环绕通知===============");
	          long start = System.currentTimeMillis();
	        	  Object result = pjp.proceed();
	              long end = System.currentTimeMillis();
	              if(logger.isInfoEnabled()){
	                  logger.info("around " + pjp + "\tUse time : " + (end - start) + " ms!");
	              }
	              System.err.println("==========结束执行controller环绕通知===============");
	               end = System.currentTimeMillis();
	              if(logger.isInfoEnabled()){
	                  logger.info("around " + pjp + "\tUse time : " + (end - start) + " ms  ");
	              }
	          }
	      
	      
	
	
}
