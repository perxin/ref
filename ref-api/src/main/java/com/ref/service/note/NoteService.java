package com.ref.service.note;

import com.github.pagehelper.PageInfo;
import com.ref.base.exception.BusinessException;
import com.ref.form.note.NoteForm;
import com.ref.model.note.Note;

/**
 *
 * Created by perxin on 2017/4/11.
 */
public interface NoteService {

    void addNoteAll(NoteForm noteForm) throws BusinessException;

    PageInfo getPage(Note note) throws BusinessException;
}
