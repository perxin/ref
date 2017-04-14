package com.ref.dao.user;

import com.ref.model.user.UserIntegral;
import org.apache.ibatis.annotations.Param;

public interface UserIntegralMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserIntegral record);

    int insertSelective(UserIntegral record);

    UserIntegral selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserIntegral record);

    int updateByPrimaryKey(UserIntegral record);

    UserIntegral selectByUserId(@Param("userId") Long userId);
}