package com.ref.model.user;

import com.ref.base.model.BaseEntity;

public class User extends BaseEntity {
    
	private static final long serialVersionUID = -3532972091664699977L;

	private Long id;

    private String name;

    private String password;

    private String phone;

    private String email;
    
    public User() {
    	super();
    	deleted = false;
    }
    
    public User(Long id, String name, String password, String phone, String email) {
    	super();
    	this.id = id;
    	this.name = name;
    	this.password = password;
    	this.phone = phone;
    	this.email = email;
    	deleted = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

	@Override
	public Object getPrimaryKey() {
		return this.id;
	}

}