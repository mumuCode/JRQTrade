package com.ch.jrq.controller;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ch.jrq.domain.TradeData;
import com.ch.jrq.service.JRQOrderInfoService;
import com.ch.jrq.service.JRQTraderInfoService;
@Controller
@RequestMapping("order/")
public class OrderInfoController {
	
	private  static  final Logger logger = LoggerFactory.getLogger(OrderInfoController. class);
	
	@Autowired
	JRQOrderInfoService jrqOrderInfoService;
	@Autowired
	JRQTraderInfoService jrqTraderInfoService;
    
	@RequestMapping("order")
	public String trade(ModelMap modelMap){
		//查询所有牛人信息
		Map<String, String> map = new HashMap<String,String>();
        List<TradeData> traderList = jrqTraderInfoService.queryTraderList(map);
        //查询所有货币信息
        List<TradeData> symbolList = jrqOrderInfoService.querySymbolList();
        
        modelMap.put("traderList", traderList);
        modelMap.put("symbolList", symbolList);
		return "order/order";
	}
	
	@RequestMapping("orderContent")
	public String tradedata(ModelMap modelMap,
			@RequestParam(value="startTime", required = false)String startTime,
			@RequestParam(value="endTime", required = false)String endTime,
			@RequestParam(value="traderId", required = false)String traderId,
			@RequestParam(value="symbol", required = false)String symbol){
		Map<String,String> queryMap = new HashMap<String,String>();
		
		//获取当前时间点的前一个月日期值
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        if(startTime == null || startTime.equals("")){
        	startTime = format.format(m);
        }
        if(endTime == null || endTime.equals("")){
        	endTime = format.format(new Date());
        }       
        String t = " 23:59:59";
        
        queryMap.put("startTime", startTime+t);
        queryMap.put("endTime", endTime+t);
        queryMap.put("traderId", traderId);
        queryMap.put("symbol", symbol);
        logger.info("查询交易订单信息请求参数："+queryMap.toString());       
        
		//查询数据
        List<TradeData> tradeList = jrqOrderInfoService.queryTradeDataList(queryMap);
                
		modelMap.put("tradeList", tradeList);
		return "order/orderContent";
	}
}
