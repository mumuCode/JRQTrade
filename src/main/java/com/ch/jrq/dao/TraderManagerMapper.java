package com.ch.jrq.dao;

import java.util.List;
import java.util.Map;

import com.ch.jrq.domain.TradeData;

public interface TraderManagerMapper {

	List<TradeData> queryTraderManagerList(Map queryMap);

	void addTrader(Map<String, String> map);

	void updateTraderStatus(Map<String, String> map);

}
