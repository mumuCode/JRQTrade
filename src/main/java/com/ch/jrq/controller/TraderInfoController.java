package com.ch.jrq.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.jrq.domain.TradeData;
import com.ch.jrq.service.JRQTraderInfoService;
import com.ch.jrq.utils.StatusJSON;
@Controller
@RequestMapping("trader/")
public class TraderInfoController {
	
	private  static  final Logger logger = LoggerFactory.getLogger(TraderInfoController. class);
	
	@Autowired
	JRQTraderInfoService jrqTraderInfoService;
    
	@RequestMapping("trader")
	public String trader(){
		return "trader/trader";
	}
	
	@RequestMapping("traderContent")
	public String traderContent(ModelMap modelMap,
			@RequestParam(value="traderStatus", required = false)String traderStatus){
		Map<String,String> queryMap = new HashMap<String,String>();
		
        queryMap.put("traderStatus", traderStatus);
        logger.info("查询牛人信息请求参数："+queryMap.toString());       
        
		//查询数据
        List<TradeData> traderList = jrqTraderInfoService.queryTraderList(queryMap);
                
		modelMap.put("traderList", traderList);
		return "trader/traderContent";
	}
	
	@RequestMapping("addTrader")
	@ResponseBody
	public StatusJSON addTrader(
			@RequestParam(value="traderName", required = true)String traderName,
			@RequestParam(value="traderId", required = true)String traderId){
		StatusJSON statusJson = new StatusJSON();
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("traderName", traderName);
		map.put("traderId", traderId);
        logger.info("添加牛人信息请求参数："+map.toString());       
        
		//添加牛人
        try {
        	jrqTraderInfoService.addTrader(map);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("添加牛人信息失败："+e);
			statusJson.setStatus(0);
			statusJson.setMessage("添加牛人失败！");
			return statusJson;
		}
        
        statusJson.setStatus(1);
		statusJson.setMessage("添加牛人成功！");
		return statusJson;
	}
	
	
	@RequestMapping("updateTraderStatus")
	public String updateTraderStatus(
			@RequestParam(value="traderStatus", required = true)String traderStatus,
			@RequestParam(value="traderId", required = true)String traderId){
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("traderStatus", traderStatus);
		map.put("traderId", traderId);
        logger.info("变更牛人状态请求参数："+map.toString());       
        
		//变更牛人状态
        try {
        	jrqTraderInfoService.updateTraderStatus(map);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("变更牛人状态失败："+e);
		}
        
		return "redirect:/traderManager/trader";
	}
	
	@RequestMapping("exportTraderFile")
	@ResponseBody
	public StatusJSON exportTraderFile(){
		StatusJSON statusJson = new StatusJSON();
		
        Map<String,String> queryMap = new HashMap<String,String>();
		queryMap.put("traderStatus", "01");
        	
        try {
        	//查询状态有效的牛人信息
        	List<TradeData> traderList = jrqTraderInfoService.queryTraderList(queryMap);
		    //生成牛人配置文件
        	jrqTraderInfoService.writeFile(traderList);
        	
        } catch (Exception e) {
			e.printStackTrace();
			logger.error("生成牛人配置文件失败："+e);
			statusJson.setStatus(0);
			statusJson.setMessage("生成牛人配置文件失败！");
			return statusJson;
		}
        
        statusJson.setStatus(1);
		statusJson.setMessage("生成牛人配置文件成功！");
		return statusJson;
	}
}
