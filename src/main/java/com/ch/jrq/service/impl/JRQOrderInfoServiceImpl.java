package com.ch.jrq.service.impl;

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
		tradeDataMapper.addOrderInfoByList(tradeDataList);
	}

}
