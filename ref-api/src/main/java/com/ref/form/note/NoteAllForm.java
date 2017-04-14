package com.ref.form.note;

import com.ref.model.note.Comment;
import com.ref.model.note.Note;

import java.io.Serializable;
import java.util.List;

/**
 *
 * Created by perxin on 2017/4/11.
 */
public class NoteAllForm extends Note implements Serializable {

    private static final long serialVersionUID = -2568029185106950455L;

    private String content;

    private List<Comment> commentList;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
