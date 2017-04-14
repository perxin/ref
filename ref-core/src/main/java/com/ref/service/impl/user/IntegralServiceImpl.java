package com.ref.service.impl.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ref.base.exception.BusinessException;
import com.ref.base.util.EntityUtil;
import com.ref.dao.user.IntegralRecordMapper;
import com.ref.dao.user.UserIntegralMapper;
import com.ref.model.user.IntegralRecord;
import com.ref.model.user.UserIntegral;
import com.ref.service.user.IntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Created by perxin on 2017/4/14.
 */
@Service
public class IntegralServiceImpl implements IntegralService {

    @Autowired
    IntegralRecordMapper integralRecordMapper;

    @Autowired
    UserIntegralMapper userIntegralMapper;

    @Override
    public int getIntegralByType(String type) {
        return 0;
    }

    @Override
    public int addIntegral(IntegralRecord record) throws BusinessException {
        EntityUtil.insertBefore(record, record.getUserId());
        integralRecordMapper.insertSelective(record);
        UserIntegral userIntegral = userIntegralMapper.selectByUserId(record.getUserId());
        if (userIntegral == null) {
            userIntegral = new UserIntegral();
            userIntegral.setTotalIntegral(record.getIntegral());
            userIntegral.setUserId(record.getUserId());
            EntityUtil.insertBefore(userIntegral, record.getUserId());
            userIntegralMapper.insertSelective(userIntegral);
        } else {
            int totalIntegral = userIntegral.getTotalIntegral() + record.getIntegral();
            userIntegral.setTotalIntegral(totalIntegral);
            EntityUtil.updateBefore(userIntegral, userIntegral.getUserId());
            userIntegralMapper.updateByPrimaryKeySelective(userIntegral);
        }
        return userIntegral.getTotalIntegral();
    }

    @Override
    public int getTotalIntegral(Long userId) throws BusinessException {
        UserIntegral userIntegral = userIntegralMapper.selectByUserId(userId);
        return userIntegral == null ? 0 : userIntegral.getTotalIntegral();
    }

    @Override
    public PageInfo<IntegralRecord> getIntegralRecordPage(int pageNum, int pageSize) throws BusinessException {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<IntegralRecord> pageInfo = new PageInfo<>(integralRecordMapper.selectPage());
        return pageInfo;
    }
}
