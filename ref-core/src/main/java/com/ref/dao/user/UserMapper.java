package com.ref.dao.user;

import com.ref.entity.user.User;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

	User selectUserByName(String name);

}
