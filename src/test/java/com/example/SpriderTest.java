package com.example;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import net.sf.json.JSONObject;

import com.ch.jrq.domain.TradeData;
import com.ch.jrq.service.JRQOrderInfoService;
import com.ch.jrq.service.impl.JRQOrderInfoServiceImpl;
import com.ch.sprider.bean.LinkTypeData;
import com.ch.sprider.core.ExtractService;
import com.ch.sprider.rule.Rule;


public class SpriderTest {
//	@Test
//	public void getDatasByClass()
//	{
//		Rule rule = new Rule(
//				"http://www1.sxcredit.gov.cn/public/infocomquery.do?method=publicIndexQuery",
//		new String[] { "query.enterprisename","query.registationnumber" }, new String[] { "兴网","" },
//				"cont_right", Rule.CLASS, Rule.POST);
//		List<LinkTypeData> extracts = (List<LinkTypeData>) ExtractService.extract(rule);
//		printf(extracts);
//	}
//
//	@Test
//	public void getDatasByCssQuery()
//	{
//		Rule rule = new Rule("http://www.11315.com/search",
//				new String[] { "name" }, new String[] { "兴网" },
//				"div.g-mn div.con-model", Rule.SELECTION, Rule.GET);
//		List<LinkTypeData> extracts = (List<LinkTypeData>) ExtractService.extract(rule);
//		printf(extracts);
//	}

	public void printf(List<LinkTypeData> datas)
	{
		for (LinkTypeData data : datas)
		{
			System.out.println(data.getLinkText());
			System.out.println(data.getLinkHref());
			System.out.println("***********************************");
		}

	}
	
	@Resource
	JRQOrderInfoServiceImpl jrqTraderInfoService;
	
	@Test
	public void getJrqDatas()
	{
		Long timeStamp = new Date().getTime();
		//持仓订单
		Rule rule1 = new Rule("https://copyfx.jrq.com/Widget/__user_published",
				new String[] { "uid","type","page","_"}, new String[] { "5055710" ,"user_trading","1",timeStamp.toString()},
				"itemlist", Rule.CLASS, Rule.GET);
		List<TradeData> extracts1 =  (List<TradeData>) ExtractService.extract(rule1,"5055710","测试");
		jrqTraderInfoService.addOrderInfoByList(extracts1);
		System.out.println("================================分割线");;
		//历史订单
		Rule rule2 = new Rule("https://copyfx.jrq.com/Widget/__user_published",
				new String[] { "uid","type","page","_"}, new String[] { "5055710" ,"user_trade_history","1",timeStamp.toString()},
				"itemlist", Rule.CLASS, Rule.GET);
		List<TradeData> extracts2 =  (List<TradeData>) ExtractService.extract(rule2,"5055710","测试");
		jrqTraderInfoService.addOrderInfoByList(extracts2);
	}
	
	//#持仓订单 https://copyfx.jrq.com/Widget/__user_published?uid=5215696&type=user_trading&page=1&_=1487135059545
    //#交易历史 https://copyfx.jrq.com/Widget/__user_published?uid=5215696&type=user_trade_history&page=1&_=1487135059537
	
    public static void main(String[] args) {
		System.out.println(new BigDecimal("1.8162199999999999").setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue()+"");
	}
    
    
}
