package com.ch.dao;

import java.util.List;
import java.util.Map;

import com.ch.domain.TradeData;

public interface TradeDataMapper {

	List<TradeData> queryTradeDataList(Map queryMap);

	List<TradeData> queryTraderList();

	List<TradeData> querySymbolList();
}
