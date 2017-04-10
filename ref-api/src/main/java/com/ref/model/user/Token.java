package com.ref.model.user;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * Created by perxin on 2017/4/7.
 */
public class Token implements Serializable {

    private Long userId;

    private String name;

    private String phone;

    private String email;

    private Date loginTime;

    private String loginIp;

    /**
     * 有效时间:单位秒
     */
    private Long expiredTime;

    public Token(long userId, String name, String phone, String email, Date loginTime, String loginIp, Long expiredTime) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.loginTime = loginTime;
        this.loginIp = loginIp;
        this.expiredTime = expiredTime;
    }

    public Token(Token token) {
        if(token != null) {
            this.userId = token.userId;
            this.name = token.name;
            this.phone = token.phone;
            this.email = token.email;
            this.loginTime = token.loginTime;
            this.loginIp = token.loginIp;
            this.expiredTime = token.expiredTime;
        }
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    @Override
    public String toString() {
        return "{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", loginTime=" + loginTime +
                ", loginIp='" + loginIp + '\'' +
                ", expiredTime=" + expiredTime +
                '}';
    }
}
