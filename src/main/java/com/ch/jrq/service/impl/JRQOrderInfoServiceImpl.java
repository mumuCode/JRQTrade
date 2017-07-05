package com.ch.jrq.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.jrq.dao.JRQOrderInfoMapper;
import com.ch.jrq.domain.TradeData;
import com.ch.jrq.service.JRQOrderInfoService;

@Service("jrqOrderInfoService")
public class JRQOrderInfoServiceImpl implements JRQOrderInfoService {
	
	@Autowired
	JRQOrderInfoMapper tradeDataMapper;

	@Override
	public List<TradeData> queryTradeDataList(Map queryMap) {
		return tradeDataMapper.queryTradeDataList(queryMap);
	}

	@Override
	public List<TradeData> queryTraderList() {		
		return tradeDataMapper.queryTraderList();
	}

	@Override
	public List<TradeData> querySymbolList() {		
		return tradeDataMapper.querySymbolList();
	}

	@Override
	public void addOrderInfoByList(List<TradeData> tradeDataList) {
		if(tradeDataList != null && tradeDataList.size() > 0){
			
			for(int i=0;i<tradeDataList.size();i++){
				
				TradeData tradeData = tradeDataList.get(i);
				String orderId = tradeData.getOrderId();
				String closeStatus = tradeData.getCloseStatus();
				
				//判断数据是否重复抓取
				Map<String,String> tradeMap = new HashMap<String,String>();
				tradeMap.put("orderId", orderId);
				TradeData data = tradeDataMapper.queryTradeData(tradeMap);
				
				if(data != null){
					//判断订单是否有变化
					if(!data.getCloseStatus().equals(closeStatus)){//0:持有 3:平仓
						//更新订单数据
						tradeDataMapper.updateOrderInfo(tradeData);
					}else{
						continue;
					}
				}else{
					//新增订单数据
					tradeDataMapper.addOrderInfo(tradeData);
				}				
				
			}
			
		}
	}

}
