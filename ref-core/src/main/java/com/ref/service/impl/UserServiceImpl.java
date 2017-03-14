package com.ref.service.impl;

import com.ref.entity.user.User;
import com.ref.dao.user.UserMapper;
import com.ref.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserByName(String name) {
		return userMapper.selectUserByName(name);
	}

}
