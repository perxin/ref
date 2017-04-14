package com.ref.form.note;

import com.ref.base.model.AbstractPage;

import javax.ws.rs.QueryParam;

/**
 *
 * Created by perxin on 2017/4/14.
 */
public class NoteSearchForm extends AbstractPage {

    private static final long serialVersionUID = -2155070542774445800L;

    @QueryParam("name")
    private String name;

    @QueryParam("noteSortId")
    private Long noteSortId;

    @QueryParam("description")
    private String description;

    @QueryParam("content")
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
