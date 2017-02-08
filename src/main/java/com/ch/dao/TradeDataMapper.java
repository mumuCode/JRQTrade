package com.ch.dao;

import java.util.List;
import java.util.Map;

public interface TradeDataMapper {

	List<Map<String,String>> queryTradeDataList(Map queryMap);
}
