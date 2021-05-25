package com.ruban.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruban.user.domain.User;
import com.ruban.usermapper.UserMapper;

@RestController
public class UserController {
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/user")
	public List<User> getUsers() {
		List<User> usersList = new ArrayList<User>();
		usersList = userMapper.listAllUser();
		return usersList;
	}
}
