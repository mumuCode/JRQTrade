package com.ch.jrq.service;

import java.util.List;
import java.util.Map;

import com.ch.jrq.domain.TradeData;

public interface JRQTraderInfoService {

	public List<TradeData> queryTraderList(Map<String,String> queryMap);

	public void addTrader(Map<String, String> map);

	public void updateTraderStatus(Map<String, String> map);

	public void writeFile(List<TradeData> traderList);

}
