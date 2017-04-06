package com.ref.model.user;

import com.ref.base.model.BaseEntity;

public class UserIntegral extends BaseEntity {
    private Integer id;

    private Integer userId;

    private Integer totalIntegral;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTotalIntegral() {
        return totalIntegral;
    }

    public void setTotalIntegral(Integer totalIntegral) {
        this.totalIntegral = totalIntegral;
    }

    @Override
    public Object getPrimaryKey() {
        return this.id;
    }
}