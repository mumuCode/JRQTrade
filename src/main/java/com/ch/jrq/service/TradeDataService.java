package com.ch.jrq.service;

import java.util.List;
import java.util.Map;

import com.ch.jrq.domain.TradeData;

public interface TradeDataService {

	public List<TradeData> queryTradeDataList(Map queryMap);

	public List<TradeData> queryTraderList();

	public List<TradeData> querySymbolList();
}
