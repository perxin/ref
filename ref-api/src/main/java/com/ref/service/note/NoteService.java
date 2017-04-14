package com.ref.service.note;

import com.github.pagehelper.PageInfo;
import com.ref.base.exception.BusinessException;
import com.ref.form.note.NoteAllForm;
import com.ref.form.note.NoteSearchForm;
import com.ref.model.note.Comment;

/**
 *
 * Created by perxin on 2017/4/11.
 */
public interface NoteService {

    void addNoteAll(NoteAllForm noteAllForm) throws BusinessException;

    PageInfo<NoteAllForm> getPage(NoteSearchForm noteSearchForm) throws BusinessException;

    PageInfo getPageHot(int pageNum, int pageSize);

    PageInfo getPageNew(int pageNum, int pageSize);

    NoteAllForm getNoteDetail(Long noteId);

    void commentAdd(Comment comment) throws BusinessException;
}
