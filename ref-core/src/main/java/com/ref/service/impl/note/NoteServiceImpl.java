package com.ref.service.impl.note;

import com.ref.base.constant.CommonConstant;
import com.ref.base.exception.BusinessException;
import com.ref.base.util.EntityUtil;
import com.ref.dao.note.NoteDataMapper;
import com.ref.dao.note.NoteMapper;
import com.ref.form.note.NoteForm;
import com.ref.model.note.Note;
import com.ref.model.note.NoteData;
import com.ref.service.note.NoteService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by perxin on 2017/4/11.
 */
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteMapper noteMapper;

    @Autowired
    private NoteDataMapper noteDataMapper;

    @Override
    public void addNoteAll(NoteForm noteForm) throws BusinessException {
        checkParam(noteForm);
        Note note = noteForm;
        EntityUtil.insertBefore(note, noteForm.getCreateBy());
        noteMapper.insertSelective(note);
        noteDataMapper.insertSelective(new NoteData(note.getPrimaryKey(), noteForm.getContent()));
    }

    private void checkParam(NoteForm noteForm) {
        if (StringUtils.isEmpty(noteForm.getName())) {
            throw new BusinessException(CommonConstant.ErrorCode.ERROR_CODE_PARAMETER_ILLEGAL, "名字不能为空");
        }
        if (StringUtils.isEmpty(noteForm.getContent())) {
            throw new BusinessException(CommonConstant.ErrorCode.ERROR_CODE_PARAMETER_ILLEGAL, "内容不能为空");
        }
    }
}
