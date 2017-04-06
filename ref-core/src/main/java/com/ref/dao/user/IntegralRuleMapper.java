package com.ref.dao.user;

import com.ref.model.user.IntegralRule;

public interface IntegralRuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IntegralRule record);

    int insertSelective(IntegralRule record);

    IntegralRule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IntegralRule record);

    int updateByPrimaryKey(IntegralRule record);
}