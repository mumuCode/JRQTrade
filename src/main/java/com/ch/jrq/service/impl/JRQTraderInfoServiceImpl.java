package com.ch.jrq.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.jrq.dao.JRQTraderInfoMapper;
import com.ch.jrq.domain.TradeData;
import com.ch.jrq.service.JRQTraderInfoService;

@Service("jrqTraderInfoService")
public class JRQTraderInfoServiceImpl implements JRQTraderInfoService {
	
	@Autowired
	JRQTraderInfoMapper jrqTraderInfoMapper;

	/**
	 * 查询牛人信息
	 * @param map
	 * @return List<TradeData>
	 */
	public List<TradeData> queryTraderList(Map<String, String> queryMap) {
		return jrqTraderInfoMapper.queryTraderList(queryMap);
	}

	@Override
	public void addTrader(Map<String, String> map) {
		jrqTraderInfoMapper.addTrader(map);
	}

	@Override
	public void updateTraderStatus(Map<String, String> map) {
		jrqTraderInfoMapper.updateTraderStatus(map);
	}

	@Override
	public void writeFile(List<TradeData> traderList) {
		
		BufferedWriter bw = null;
		
		try {
			File traderFile = new File("/home/shell/trader.ini");
			
			//获取牛人编号
			StringBuilder traderMessage = new StringBuilder();
			for(int i=0;i<traderList.size();i++){
			    TradeData trader = traderList.get(i);
			    if(i < (traderList.size()-1)){
			    	//traderMessage.append(trader.getTraderId()+",");
			    }else{
			    	//traderMessage.append(trader.getTraderId());
			    }			    
			}
			
			//写入数据
			traderMessage.append("\r\n");
			bw = new BufferedWriter(new FileWriter(traderFile));
			bw.write(traderMessage.toString());
			
		    
		} catch (Exception e) {
			throw new RuntimeException("生成牛人配置文件失败："+e);
		} finally {
            // 关闭流
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    bw = null;
                }
            }
		}
	}

}
