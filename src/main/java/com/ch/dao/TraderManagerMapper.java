package com.ch.dao;

import java.util.List;
import java.util.Map;

public interface TraderManagerMapper {

	List<Map<String, String>> queryTraderManagerList(Map queryMap);

}
