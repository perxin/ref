package com.ref.model.user;

import com.ref.base.model.BaseEntity;

public class UserIntegral extends BaseEntity {
    private static final long serialVersionUID = -787072223195246994L;

    private Long id;

    private Long userId;

    private Integer totalIntegral;

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

    public Integer getTotalIntegral() {
        return totalIntegral;
    }

    public void setTotalIntegral(Integer totalIntegral) {
        this.totalIntegral = totalIntegral;
    }

    @Override
    public Long getPrimaryKey() {
        return this.id;
    }
}