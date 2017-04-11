package com.ref.model.user;

import com.ref.base.model.BaseEntity;

public class IntegralRecord extends BaseEntity {
    private Long id;

    private Long userId;

    private Integer integral;

    private Integer integralRuleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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
    public Long getPrimaryKey() {
        return this.id;
    }
}