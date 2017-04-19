package com.ch.sprider.scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ch.jrq.controller.TraderManagerController;

/**
 * 金融圈爬虫定时任务
 * @author chenheng
 *
 */
@Component
public class JRQSpriderScheduled {
	
	private  static  final Logger logger = LoggerFactory.getLogger(TraderManagerController. class);

	@Scheduled(cron="0 0/2 * * * ?") 
    public void executeSpriderTask() {

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.info("执行爬虫定时任务，时间："+sf.format(new Date()));
		//查询牛人信息
		
		
		
		//Thread current = Thread.currentThread(); 
        //logger.info("JRQSpriderScheduled.executeSpriderTask 定时任务1:"+current.getId()+ ",name:"+current.getName());
    }
	
//	@Scheduled(cron="0 0/3 * * * ?") 
//    public void executeTestTask() {
//
//        //SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		
//        Thread current = Thread.currentThread(); 
//        //logger.info("执行爬虫定时任务，时间："+sf.format(new Date()));
//        logger.info("JRQSpriderScheduled.executeTestTask 定时任务2:"+current.getId()+ ",name:"+current.getName());
//    }
}
