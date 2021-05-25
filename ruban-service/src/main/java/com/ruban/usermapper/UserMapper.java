package com.ruban.usermapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ruban.user.domain.User;

@Mapper
public interface UserMapper {
	List<User> listAllUser();
}
