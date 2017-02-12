package com.ch.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.dao.TradeDataMapper;
import com.ch.service.TradeDataService;

@Service("tradeDataService")
public class TradeDataServiceImpl implements TradeDataService {
	
	@Autowired
	TradeDataMapper tradeDataMapper;

	@Override
	public List<Map<String, String>> queryTradeDataList(Map queryMap) {

		return tradeDataMapper.queryTradeDataList(queryMap);
	}

	@Override
	public List<Map<String, String>> queryTraderList() {
		
		return tradeDataMapper.queryTraderList();
	}

	@Override
	public List<Map<String, String>> querySymbolList() {
		
		return tradeDataMapper.querySymbolList();
	}

}
