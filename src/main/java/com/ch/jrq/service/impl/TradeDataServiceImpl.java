package com.ch.jrq.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.jrq.dao.TradeDataMapper;
import com.ch.jrq.domain.TradeData;
import com.ch.jrq.service.TradeDataService;

@Service("tradeDataService")
public class TradeDataServiceImpl implements TradeDataService {
	
	@Autowired
	TradeDataMapper tradeDataMapper;

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

}
