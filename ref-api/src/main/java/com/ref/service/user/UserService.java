package com.ref.service.user;

import com.ref.base.exception.BusinessException;
import com.ref.model.user.User;

public interface UserService {

	User add(String name, String password) throws BusinessException;

	User getUserByName(String name) throws BusinessException;

	User postLogin(String name, String password) throws BusinessException;

    User getUserById(Long userId);

	String chat(String info, String userId, String ioc);
}
