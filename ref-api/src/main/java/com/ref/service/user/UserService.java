package com.ref.service.user;

import com.ref.base.exception.BusinessException;
import com.ref.model.user.User;

public interface UserService {

	void add(String name, String password) throws BusinessException;

	User getUserByName(String name) throws BusinessException;

	void postLogin(String name, String password) throws BusinessException;

}
