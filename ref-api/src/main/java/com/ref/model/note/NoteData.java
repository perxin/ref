package com.ref.model.note;

import com.ref.base.model.BaseEntity;

public class NoteData extends BaseEntity {

    private static final long serialVersionUID = 5180787159103106447L;

    private Long id;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public Object getPrimaryKey() {
        return this.id;
    }
}