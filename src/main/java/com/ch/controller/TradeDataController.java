package com.ch.controller;


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

import com.ch.annotation.SystemLogAspect;
import com.ch.service.TradeDataService;
@Controller
@RequestMapping("trade/")
public class TradeDataController {
	
	private  static  final Logger logger = LoggerFactory.getLogger(TradeDataController. class);
	
	@Autowired
	TradeDataService tradeDataService;
    
	@RequestMapping("trade")
	public String trade(ModelMap modelMap){
		//查询所有牛人信息
        List<Map<String,String>> traderList = tradeDataService.queryTraderList();
        //查询所有货币信息
        List<Map<String,String>> symbolList = tradeDataService.querySymbolList();
        
        modelMap.put("traderList", traderList);
        modelMap.put("symbolList", symbolList);
		return "trade/tradedata";
	}
	
	@RequestMapping("tradedata")
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
        List<Map<String,String>> tradeList = tradeDataService.queryTradeDataList(queryMap);
                
		modelMap.put("tradeList", tradeList);
		return "trade/tradeContent";
	}
}
