package com.ref.service.impl.note;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ref.base.constant.CommonConstant;
import com.ref.base.exception.BusinessException;
import com.ref.base.util.EntityUtil;
import com.ref.dao.note.CommentMapper;
import com.ref.dao.note.NoteDataMapper;
import com.ref.dao.note.NoteMapper;
import com.ref.form.note.NoteAllForm;
import com.ref.form.note.NoteSearchForm;
import com.ref.model.note.Comment;
import com.ref.model.note.Note;
import com.ref.model.note.NoteData;
import com.ref.service.note.NoteService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Created by perxin on 2017/4/11.
 */
@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteMapper noteMapper;

    @Autowired
    private NoteDataMapper noteDataMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void addNoteAll(NoteAllForm noteAllForm) throws BusinessException {
        checkParam(noteAllForm);
        Note note = noteAllForm;
        EntityUtil.insertBefore(note, noteAllForm.getCreateBy());
        noteMapper.insertSelective(note);
        noteDataMapper.insertSelective(new NoteData(note.getPrimaryKey(), noteAllForm.getContent()));
    }

    private void checkParam(NoteAllForm noteAllForm) {
        if (StringUtils.isEmpty(noteAllForm.getName())) {
            throw new BusinessException(CommonConstant.ErrorCode.ERROR_CODE_PARAMETER_ILLEGAL, "名字不能为空");
        }
        if (StringUtils.isEmpty(noteAllForm.getContent())) {
            throw new BusinessException(CommonConstant.ErrorCode.ERROR_CODE_PARAMETER_ILLEGAL, "内容不能为空");
        }
    }

    @Override
    public PageInfo<NoteAllForm> getPage(NoteSearchForm noteSearchForm) throws BusinessException {
        PageInfo<NoteAllForm> pageInfo = new PageInfo<>(noteMapper.selectSelective((NoteSearchForm) noteSearchForm.startPage()));
        return pageInfo;
    }

    @Override
    public PageInfo getPageHot(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Note> pageInfo = new PageInfo<>(noteMapper.selectHot());
        return pageInfo;
    }

    @Override
    public PageInfo getPageNew(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Note> pageInfo = new PageInfo<>(noteMapper.selectNewDate());
        return pageInfo;
    }

    @Override
    public NoteAllForm getNoteDetail(Long noteId) {
        NoteAllForm noteAllForm = (NoteAllForm) noteMapper.selectByPrimaryKey(noteId);
        NoteData noteData = noteDataMapper.selectByPrimaryKey(noteId);
        if (noteData != null) {
            noteAllForm.setContent(noteData.getContent());
        }
        noteAllForm.setCommentList(commentMapper.selectByNoteId(noteId));
        return noteAllForm;
    }

    @Override
    public void commentAdd(Comment comment) throws BusinessException {

    }
}
