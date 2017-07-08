package com.ch.sprider.scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;

import org.apache.tomcat.jni.Thread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import com.ch.jrq.controller.TraderInfoController;
import com.ch.jrq.domain.TradeData;
import com.ch.jrq.service.JRQOrderInfoService;
import com.ch.jrq.service.JRQTraderInfoService;
import com.ch.sprider.bean.LinkTypeData;
import com.ch.sprider.core.ExtractService;
import com.ch.sprider.rule.Rule;

/**
 * 金融圈爬虫定时任务
 * @author chenheng
 *
 */
@Component
public class JRQSpriderScheduled {
	
	private  static  final Logger logger = LoggerFactory.getLogger(TraderInfoController. class);
	
	@Autowired
	JRQTraderInfoService traderManagerService;
	@Autowired
	JRQOrderInfoService orderInfoService;
	
	@Resource(name = "threadPoolTaskExecutor")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

	@Scheduled(cron="0 0/5 * * * ?") 
    public void executeSpriderTask() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info(sf.format(new Date())+" 开始执行定时任务");	
        
		final ConcurrentLinkedQueue<TradeData> queue = new ConcurrentLinkedQueue<TradeData>();//数据队列
		Integer threadCount = 4;//线程数
		final CountDownLatch latch = new CountDownLatch(threadCount);//线程等待
		
		//查询有效牛人信息
		Map<String,String> map = new HashMap<String,String>();
		map.put("traderStatus", "01");//01 有效
		List<TradeData> traderList = traderManagerService.queryTraderList(map);
		
		int processCount = traderList.size();//抓取牛人数据总数
		final AtomicInteger succCount = new AtomicInteger(0);//成功抓取数
		final AtomicInteger failCount = new AtomicInteger(0);//失败抓取数
		
		final String traderUrl = "https://copyfx.jrq.com/Widget/__user_published";
		final String[] paramsName = new String[] {"uid","type","page","_"};
		final String traderFlag = "user_trading";
		final String traderHistoryFlag = "user_trade_history";
		
		//将数据加入队列中
		queue.addAll(traderList);
		//循环请求每个牛人订单信息
		for(int i=0;i<threadCount;i++){
			threadPoolTaskExecutor.execute(new Runnable() {
				
				@Override
				public void run() {
					while (!queue.isEmpty()) {
						
						TradeData tradeData = queue.poll();
		        		if(tradeData != null){
		        			String traderId = tradeData.getTraderId();
		    				String traderName = tradeData.getTraderName();
			    			try{			    				
			    				logger.info("抓取牛人："+traderName+"的交易数据，牛人ID："+traderId+"###Start");
			    				Long timeStamp = new Date().getTime();
			    				//爬虫获取持仓订单			    				
			    				//持仓订单
								Rule rule1 = new Rule(traderUrl, paramsName,
										new String[] { traderId,
										traderFlag, "1",
												timeStamp.toString() },
										"itemlist", Rule.CLASS, Rule.GET);
								List<TradeData> extracts1 =  (List<TradeData>) ExtractService.extract(rule1,traderId,traderName);
								orderInfoService.addOrderInfoByList(extracts1);
			    				
			    				//爬虫获取交易历史
								Rule rule2 = new Rule(traderUrl, paramsName,
										new String[] { traderId,
										traderHistoryFlag, "1",
												timeStamp.toString() },
										"itemlist", Rule.CLASS, Rule.GET);
								List<TradeData> extracts2 =  (List<TradeData>) ExtractService.extract(rule2,traderId,traderName);
								orderInfoService.addOrderInfoByList(extracts2);
								
			    				logger.info("抓取牛人："+tradeData.getTraderName()+"的交易数据，牛人ID："+traderId+"###End");

			    				succCount.incrementAndGet();
			    			} catch (Exception e) {
			    				logger.info("抓取牛人："+tradeData.getTraderName()+"的交易数据，牛人ID："+traderId+"###End，异常："+e);
			    				failCount.incrementAndGet();
			    			}
		        		}			        		
		            }
		            latch.countDown();
				}
			});
		}
	    
	    logger.info("执行爬虫定时任务，时间："+sf.format(new Date())+",共请求牛人："+processCount+",成功请求："+succCount+",失败请求："+failCount);

    }
}
