package com.ref.service;

import com.ic.base.exception.BusinessException;
import com.ref.entity.user.User;

public interface UserService {

	void add(User user) throws BusinessException;

	User getUserByName(String name) throws BusinessException;

}
