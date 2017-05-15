package com.ref.model.note;

import com.ref.base.model.BaseEntity;

public class Note extends BaseEntity {

    private static final long serialVersionUID = 300772255904564444L;

    private Long id;

    private String name;

    private Long noteSortId;

    private String description;

    private Integer views;

    private Integer comments;

    private Integer praiseNumber;

    private String userName;

    public Note() {
    }

    public Note(Long id, Integer views, Integer comments, Integer praiseNumber) {
        this.id = id;
        this.views = views;
        this.comments = comments;
        this.praiseNumber = praiseNumber;
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

    public Long getNoteSortId() {
        return noteSortId;
    }

    public void setNoteSortId(Long noteSortId) {
        this.noteSortId = noteSortId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getPraiseNumber() {
        return praiseNumber;
    }

    public void setPraiseNumber(Integer praiseNumber) {
        this.praiseNumber = praiseNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public Long getPrimaryKey() {
        return this.id;
    }
}