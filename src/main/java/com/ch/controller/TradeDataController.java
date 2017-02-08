package com.ch.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.service.TradeDataService;
@Controller
@RequestMapping("trade/")
public class TradeDataController {
	
	@Autowired
	TradeDataService tradeDataService;
    
	@RequestMapping("trade")
	public String trade(){
		return "trade/tradedata";
	}
	
	@RequestMapping("tradedata")
	public String tradedata(ModelMap modelMap){
		Map<String,String> queryMap = new HashMap<String,String>();
		List<Map<String,String>> tradeList = tradeDataService.queryTradeDataList(queryMap);
		modelMap.put("tradeList", tradeList);
		return "trade/tradeContent";
	}
}
