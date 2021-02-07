package com.zll.riskcontrol.usermapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zll.riskcontrol.domain.User;

@Mapper
public interface UserMapper {
	List<User> listAllUser();
}
