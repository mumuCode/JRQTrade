package com.ch.jrq.dao;

import com.ch.jrq.domain.SystemLog;

public interface SystemLogMapper {

    int insert(SystemLog record);

    int insertSelective(SystemLog record);

}