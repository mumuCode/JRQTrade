package com.ch.jrq.dao;

import java.util.List;
import java.util.Map;

import com.ch.jrq.domain.TradeData;

public interface JRQTraderInfoMapper {
	
	List<TradeData> queryTraderList(Map<String, String> map);

	void addTrader(Map<String, String> map);

	void updateTraderStatus(Map<String, String> map);

	TradeData queryTrader(Map<String, String> map);

}
