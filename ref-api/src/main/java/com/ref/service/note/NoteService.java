package com.ref.service.note;

import com.github.pagehelper.PageInfo;
import com.ref.base.exception.BusinessException;
import com.ref.form.note.NoteAllForm;
import com.ref.model.note.Comment;
import com.ref.model.note.Note;

/**
 *
 * Created by perxin on 2017/4/11.
 */
public interface NoteService {

    void addNoteAll(NoteAllForm noteAllForm) throws BusinessException;

    PageInfo<Note> getPage(Note note) throws BusinessException;

    PageInfo getPageHot(int pageNum, int pageSize);

    PageInfo getPageNew(int pageNum, int pageSize);

    NoteAllForm getNoteDetail(String noteId);

    void commentAdd(Comment comment);
}
