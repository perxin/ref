package com.ref.service.note;

import com.ref.base.exception.BusinessException;
import com.ref.form.note.NoteForm;

/**
 *
 * Created by perxin on 2017/4/11.
 */
public interface NoteService {

    void addNoteAll(NoteForm noteForm) throws BusinessException;


}
