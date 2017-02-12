package com.ch.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.dao.TraderManagerMapper;
import com.ch.service.TraderManagerService;

@Service("traderManagerService")
public class TraderManagerServiceImpl implements TraderManagerService {
	
	@Autowired
	TraderManagerMapper traderManagerMapper;

	@Override
	public List<Map<String, String>> queryTraderManagerList(Map queryMap) {
		return traderManagerMapper.queryTraderManagerList(queryMap);
	}

}
