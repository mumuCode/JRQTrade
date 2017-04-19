package com.ch.jrq.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ch.jrq.dao.SystemLogMapper;
import com.ch.jrq.domain.SystemLog;
import com.ch.jrq.service.SystemLogService;

@Service("systemLogService")
public class SystemLogServiceImpl implements SystemLogService {

    @Resource
    private SystemLogMapper systemLogMapper;
    

    @Override
    
    public int insert(SystemLog record) {
        
        return systemLogMapper.insertSelective(record);
    }

    

    @Override
    public int insertTest(SystemLog record) {
        
        return systemLogMapper.insert(record);
    }

}