package com.ref.base.util;

import com.ref.base.model.BaseEntity;

import java.util.Date;

/**
 * Created by perxin on 2017/3/30.
 */
public class EntityUtil {

    public static void insertBefore(BaseEntity entity) {
        ParamUtil.checkNotNull(entity);
        entity.setCreateDate(new Date());
        entity.setUpdateDate(new Date());
    }

    public static void insertBefore(BaseEntity entity, String userId) {
        insertBefore(entity);
        entity.setCreateBy(userId);
        entity.setUpdateBy(userId);
    }

    public static void updateBefore(BaseEntity entity) {
        ParamUtil.checkNotNull(entity);
        entity.setUpdateDate(new Date());
    }

    public static void updateBefore(BaseEntity entity, String userId) {
        updateBefore(entity);
        entity.setUpdateBy(userId);
    }

}
