package com.ch.service;

import java.util.List;
import java.util.Map;

import com.ch.domain.TradeData;

public interface TraderManagerService {

	public List<TradeData> queryTraderManagerList(Map queryMap);

	public void addTrader(Map<String, String> map);

	public void updateTraderStatus(Map<String, String> map);

	public void writeFile(List<TradeData> traderList);
}
