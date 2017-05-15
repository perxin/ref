package com.ref.service.user;

import com.github.pagehelper.PageInfo;
import com.ref.base.exception.BusinessException;
import com.ref.model.user.IntegralRecord;

/**
 *
 * Created by perxin on 2017/4/13.
 */
public interface IntegralService {

    int getIntegralByType(String type);

    int addIntegral(IntegralRecord record) throws BusinessException;

    int getTotalIntegral(Long userId) throws BusinessException;

    PageInfo<IntegralRecord> getIntegralRecordPage(int pageNum, int pageSize, Long userId) throws BusinessException;
}
