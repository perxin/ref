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
        if (noteMapper.selectByName(noteAllForm.getName()) != null) {
            throw new BusinessException(CommonConstant.ErrorCode.ERROR_CODE_PARAMETER_ILLEGAL, "该文章标题已经存在");
        }
        Note note = noteAllForm;
        EntityUtil.insertBefore(note, noteAllForm.getCreateBy());
        noteMapper.insertSelective(note);
        noteDataMapper.insertSelective(new NoteData(note.getPrimaryKey(), noteAllForm.getContent()));
    }

    @Override
    public void modify(NoteAllForm noteAllForm) throws BusinessException {
        checkParam(noteAllForm);
        Note note = noteAllForm;
        EntityUtil.updateBefore(note, noteAllForm.getCreateBy());
        noteMapper.updateByPrimaryKeySelective(note);
        noteDataMapper.updateByPrimaryKeySelective(new NoteData(note.getPrimaryKey(), noteAllForm.getContent()));
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
        noteCount(noteId, 0);
        NoteAllForm noteAllForm = noteMapper.selectById(noteId);
        NoteData noteData = noteDataMapper.selectByPrimaryKey(noteId);
        if (noteData != null) {
            noteAllForm.setContent(noteData.getContent());
        }
        noteAllForm.setCommentList(commentMapper.selectByNoteId(noteId));
        return noteAllForm;
    }

    @Override
    public void commentAdd(Comment comment) throws BusinessException {
        checkParamComment(comment);
        EntityUtil.insertBefore(comment, comment.getCreateBy());
        commentMapper.insertSelective(comment);
        noteCount(comment.getNoteId(), 1);
    }

    private void noteCount(Long noteId, int type) throws BusinessException {
        Note note = noteMapper.selectByPrimaryKey(noteId);
        switch (type) {
            case (0) :
                note.setViews(note.getViews() + 1);
                break;
            case (1) :
                note.setComments(note.getComments() + 1);
                break;
            case (2) :
                note.setPraiseNumber(note.getPraiseNumber() + 1);
                break;
        }
        noteMapper.updateByPrimaryKeySelective(note);
    }

    private void checkParam(NoteAllForm noteAllForm) throws BusinessException {
        if (StringUtils.isEmpty(noteAllForm.getName())) {
            throw new BusinessException(CommonConstant.ErrorCode.ERROR_CODE_PARAMETER_ILLEGAL, "标题不能为空");
        }
        if (StringUtils.isEmpty(noteAllForm.getContent())) {
            throw new BusinessException(CommonConstant.ErrorCode.ERROR_CODE_PARAMETER_ILLEGAL, "内容不能为空");
        }
    }

    private void checkParamComment(Comment comment) throws BusinessException {
        if (comment.getNoteId() == null) {
            throw new BusinessException(CommonConstant.ErrorCode.ERROR_CODE_PARAMETER_ILLEGAL, "文章id不能为空");
        }
        if (StringUtils.isEmpty(comment.getContent())) {
            throw new BusinessException(CommonConstant.ErrorCode.ERROR_CODE_PARAMETER_ILLEGAL, "内容不能为空");
        }
    }
}
