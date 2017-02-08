package com.ch.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ch.dao.SystemLogMapper;
import com.ch.domain.SystemLog;
import com.ch.service.SystemLogService;

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