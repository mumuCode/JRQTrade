package com.ch.service;

import java.util.List;
import java.util.Map;

public interface TradeDataService {

	public List<Map<String,String>> queryTradeDataList(Map queryMap);
}
