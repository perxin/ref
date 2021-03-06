package com.ref.dao.user;

import com.ref.model.user.IntegralRecord;

import java.util.List;

public interface IntegralRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IntegralRecord record);

    int insertSelective(IntegralRecord record);

    IntegralRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IntegralRecord record);

    int updateByPrimaryKey(IntegralRecord record);

    List<IntegralRecord> selectPage();
}