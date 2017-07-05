package com.ch.jrq.dao;

import java.util.List;
import java.util.Map;

import com.ch.jrq.domain.TradeData;

public interface JRQOrderInfoMapper {

	List<TradeData> queryTradeDataList(Map queryMap);

	List<TradeData> queryTraderList();

	List<TradeData> querySymbolList();

	void addOrderInfoByList(List<TradeData> tradeDataList);
}
