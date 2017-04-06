package com.ref.form.user;

import javax.ws.rs.QueryParam;

/**
 * Created by perxin on 2017/4/6.
 */
public class UserForm {

    @QueryParam("name")
    private String name;

    @QueryParam("password")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
