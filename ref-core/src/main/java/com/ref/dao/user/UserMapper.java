package com.ref.dao.user;

import com.ref.model.user.User;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

	int deleteByPrimaryKey(Long id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	User selectUserByName(String name);

}
