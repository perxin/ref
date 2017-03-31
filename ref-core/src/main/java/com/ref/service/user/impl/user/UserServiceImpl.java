package com.ref.service.user.impl.user;

import com.ref.base.exception.BusinessException;
import com.ref.base.constant.CommonConstant.ErrorCode;
import com.ref.base.util.EntityUtil;
import com.ref.base.util.MD5Util;
import com.ref.dao.user.UserMapper;
import com.ref.model.user.User;
import com.ref.service.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public void add(User user) throws BusinessException {
		if (StringUtils.isBlank(user.getName()) || StringUtils.isBlank(user.getPassword())) {
			throw new BusinessException(ErrorCode.ERROR_CODE_PARAMETER_ILLEGAL);
		}
		user.setPassword(MD5Util.encrypt(user.getPassword()));
		EntityUtil.insertBefore(user);
		userMapper.insertSelective(user);
	}

	@Override
	public User getUserByName(String name) throws BusinessException {
		return userMapper.selectUserByName(name);
	}

	@Override
	public void postLogin(String name, String password) throws BusinessException {
		if (StringUtils.isBlank(name) || StringUtils.isBlank(password)) {
			throw new BusinessException(ErrorCode.ERROR_CODE_ACCOUNT_ERROR);
		}
		User user = userMapper.selectUserByName(name);
		if (user == null || !user.getPassword().equals(MD5Util.encrypt(password))) {
			throw new BusinessException(ErrorCode.ERROR_CODE_ACCOUNT_ERROR);
		}
	}
}
