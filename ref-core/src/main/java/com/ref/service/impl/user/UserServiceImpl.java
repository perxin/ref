package com.ref.service.impl.user;

import com.ref.base.constant.CommonConstant.ErrorCode;
import com.ref.base.exception.BusinessException;
import com.ref.base.util.EntityUtil;
import com.ref.base.util.JsonUtil;
import com.ref.base.util.MD5Util;
import com.ref.dao.user.UserMapper;
import com.ref.model.user.User;
import com.ref.service.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	private final UserMapper userMapper;

	@Autowired
	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User add(String name, String password) throws BusinessException {
		if (StringUtils.isBlank(name) || StringUtils.isBlank(password)) {
			throw new BusinessException(ErrorCode.ERROR_CODE_PARAMETER_ILLEGAL);
		}
		User existUser = getUserByName(name);
		if (existUser != null) {
			throw new BusinessException(ErrorCode.ERROR_CODE_CUSTOM, "此用户名已存在");
		}
		User user = new User();
		user.setName(name);
		user.setPassword(MD5Util.encrypt(password));
		EntityUtil.insertBefore(user);
		logger.info(JsonUtil.objectToJson(user));
		userMapper.insertSelective(user);
        return user;
	}

	@Override
	public User getUserByName(String name) throws BusinessException {
		return userMapper.selectUserByName(name);
	}

	@Override
	public User postLogin(String name, String password) throws BusinessException {
		if (StringUtils.isBlank(name) || StringUtils.isBlank(password)) {
			throw new BusinessException(ErrorCode.ERROR_CODE_ACCOUNT_ERROR);
		}
		User user = userMapper.selectUserByName(name);
		if (user == null || !user.getPassword().equals(MD5Util.encrypt(password))) {
			throw new BusinessException(ErrorCode.ERROR_CODE_ACCOUNT_ERROR);
		}
		return user;
	}
}
