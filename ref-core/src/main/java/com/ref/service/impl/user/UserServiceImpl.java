package com.ref.service.impl.user;

import com.alibaba.fastjson.JSONObject;
import com.ref.base.constant.CommonConstant.ErrorCode;
import com.ref.base.exception.BusinessException;
import com.ref.base.util.EntityUtil;
import com.ref.base.util.HttpRestUtils;
import com.ref.base.util.JsonUtil;
import com.ref.base.util.MD5Util;
import com.ref.dao.user.UserMapper;
import com.ref.model.user.IntegralRecord;
import com.ref.model.user.User;
import com.ref.service.user.IntegralService;
import com.ref.service.user.UserService;
import com.ref.util.RingConstant;
import com.ref.util.RingUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	private final UserMapper userMapper;

	@Autowired
	private IntegralService integralService;

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

		integralService.addIntegral(new IntegralRecord(user.getId(), 20, "注册"));
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
		integralService.addIntegral(new IntegralRecord(user.getId(), 2, "登录"));
		return user;
	}

	@Override
	public User getUserById(Long userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public String chat(String info, String userId, String ioc) {
		Map<String, String> json = new HashMap<>();
		json.put(RingConstant.RING_KEY, RingUtil.key);
		json.put(RingConstant.RING_INFO, info);
		json.put(RingConstant.RING_USER_ID, userId);
		json.put(RingConstant.RING_LOC, ioc);
		JSONObject jsonObject = (JSONObject) JSONObject.toJSON(json);
		String request = jsonObject.toString();
		try {
			HttpRestUtils.HttpResult result = HttpRestUtils.fetchPostURLContent(RingUtil.url, null, "UTF-8", false, null, request);
			return result.getResultString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
