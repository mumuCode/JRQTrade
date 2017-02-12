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

import com.ch.service.TraderManagerService;
@Controller
@RequestMapping("traderManager/")
public class TraderManagerController {
	
	private  static  final Logger logger = LoggerFactory.getLogger(TraderManagerController. class);
	
	@Autowired
	TraderManagerService traderManagerService;
    
	@RequestMapping("trader")
	public String trade(ModelMap modelMap){
		return "traderManager/traderdata";
	}
	
	@RequestMapping("traderdata")
	public String tradedata(ModelMap modelMap,
			@RequestParam(value="traderStatus", required = false)String traderStatus){
		Map<String,String> queryMap = new HashMap<String,String>();
		
        queryMap.put("traderStatus", traderStatus);
        logger.info("查询牛人信息请求参数："+queryMap.toString());       
        
		//查询数据
        List<Map<String,String>> traderList = traderManagerService.queryTraderManagerList(queryMap);
                
		modelMap.put("traderList", traderList);
		return "traderManager/traderContent";
	}
}
