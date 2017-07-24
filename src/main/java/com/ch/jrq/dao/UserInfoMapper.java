package com.ch.jrq.dao;

import java.util.List;
import java.util.Map;

import com.ch.jrq.domain.User;

public interface UserInfoMapper {

	public List<User> queryUserInfo(Map<String, String> map);

}
