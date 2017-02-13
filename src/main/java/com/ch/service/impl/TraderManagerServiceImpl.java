package com.ch.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.dao.TraderManagerMapper;
import com.ch.domain.TradeData;
import com.ch.service.TraderManagerService;

@Service("traderManagerService")
public class TraderManagerServiceImpl implements TraderManagerService {
	
	@Autowired
	TraderManagerMapper traderManagerMapper;

	@Override
	public List<TradeData> queryTraderManagerList(Map queryMap) {
		return traderManagerMapper.queryTraderManagerList(queryMap);
	}

	@Override
	public void addTrader(Map<String, String> map) {
		traderManagerMapper.addTrader(map);
	}

	@Override
	public void updateTraderStatus(Map<String, String> map) {
		traderManagerMapper.updateTraderStatus(map);
	}

	@Override
	public void writeFile(List<TradeData> traderList) {
		
		try {
			File traderFile = new File("D:/trader.ini");
			if (traderFile.exists()) {
				traderFile.delete();
			}
			try {
				traderFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			StringBuilder traderMessage = new StringBuilder();
			for(int i=0;i<traderList.size();i++){
			    TradeData trader = traderList.get(i);
			    if(i < (traderList.size()-1)){
			    	traderMessage.append(trader.getTraderId()+",");
			    }else{
			    	traderMessage.append(trader.getTraderId());
			    }
			    
			}
			
			//写入数据			
			FileOutputStream fop = new FileOutputStream(traderFile,true);
			OutputStreamWriter isr = new OutputStreamWriter(fop,"UTF-8"); //指定以UTF-8编码写入
		    isr.write(traderMessage.toString());	    
		    isr.flush();
			isr.close();
		} catch (Exception e) {
			throw new RuntimeException("生成牛人配置文件失败："+e);
		}
		
	}

}
