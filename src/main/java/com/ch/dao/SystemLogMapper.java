package com.ch.dao;

import com.ch.domain.SystemLog;

public interface SystemLogMapper {

    int insert(SystemLog record);

    int insertSelective(SystemLog record);

}