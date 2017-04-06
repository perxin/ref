package com.ref.model.user;

import com.ref.base.model.BaseEntity;

public class IntegralRecord extends BaseEntity {
    private Integer id;

    private Integer userId;

    private Integer integral;

    private Integer integralRuleId;

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

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getIntegralRuleId() {
        return integralRuleId;
    }

    public void setIntegralRuleId(Integer integralRuleId) {
        this.integralRuleId = integralRuleId;
    }

    @Override
    public Object getPrimaryKey() {
        return this.id;
    }
}