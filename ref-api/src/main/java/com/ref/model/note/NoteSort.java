package com.ref.model.note;

import com.ref.base.model.BaseEntity;

public class NoteSort extends BaseEntity {
    private Long id;

    private Long parentId;

    private String name;

    private Integer level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public Long getPrimaryKey() {
        return this.id;
    }

}