package com.ref.resources.note;

import com.github.pagehelper.PageInfo;
import com.ref.base.exception.BusinessException;
import com.ref.base.model.BaseResult;
import com.ref.constant.PathConstants;
import com.ref.form.note.NoteAllForm;
import com.ref.form.note.NoteSearchForm;
import com.ref.model.note.Comment;
import com.ref.resources.BaseResource;
import com.ref.service.note.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * Created by perxin on 2017/4/11.
 */
@Controller
public class NoteResource extends BaseResource {

    private Logger log = LoggerFactory.getLogger(NoteResource.class);

    @Autowired
    private NoteService noteService;

    @RequestMapping(PathConstants.ROUTE_EDIT)
    public ModelAndView edit() {
        ModelAndView view = new ModelAndView();
        view.setViewName("/edit");
        return view;
    }

    @ResponseBody
    @RequestMapping(PathConstants.ROUTE_NOTE_ADD)
    public BaseResult add(HttpServletRequest request, NoteAllForm noteAllForm) {
        try {
            noteAllForm.setCreateBy(getUserId(request));
            noteService.addNoteAll(noteAllForm);
            return successResult();
        } catch (BusinessException e) {
            return erroResult(e.getDescription());
        }
    }

    @ResponseBody
    @RequestMapping(PathConstants.ROUTE_NOTE_MODIFY)
    public BaseResult modify(HttpServletRequest request, NoteAllForm noteAllForm) {
        try {
            noteAllForm.setCreateBy(getUserId(request));
            noteService.modify(noteAllForm);
            return successResult();
        } catch (BusinessException e) {
            return erroResult(e.getDescription());
        }
    }

    @ResponseBody
    @RequestMapping(PathConstants.ROUTE_NOTE_GET_PAGE)
    public PageInfo getPage(NoteSearchForm noteSearchForm) {
        PageInfo pageInfo = noteService.getPage(noteSearchForm);
        return pageInfo;
    }

    @RequestMapping(PathConstants.ROUTE_NOTE_PAGE)
    public ModelAndView notePage(NoteSearchForm noteSearchForm) {
        PageInfo pageInfo = noteService.getPage(noteSearchForm);
        ModelAndView view = new ModelAndView();
        view.setViewName("/notePage");
        view.addObject("page", pageInfo);
        return view;
    }

    @ResponseBody
    @RequestMapping(PathConstants.ROUTE_NOTE_GET_PAGE_HOT)
    public PageInfo getPageHot(int pageNum, int pageSize) {
        PageInfo pageInfo = noteService.getPageHot(pageNum, pageSize);
        return pageInfo;
    }

    @ResponseBody
    @RequestMapping(PathConstants.ROUTE_NOTE_GET_PAGE_NEW)
    public PageInfo getPageNew(int pageNum, int pageSize) {
        PageInfo pageInfo = noteService.getPageNew(pageNum, pageSize);
        return pageInfo;
    }

    @RequestMapping(PathConstants.ROUTE_NOTE_GET_NOTE_DETAIL)
    public ModelAndView noteDetail(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        NoteAllForm noteAllForm = noteService.getNoteDetail(id);
        ModelAndView view = new ModelAndView();
        view.addObject("noteAllForm", noteAllForm);
        view.setViewName("/note");
        return view;
    }

    @ResponseBody
    @RequestMapping(PathConstants.ROUTE_NOTE_COMMENT_ADD)
    public void commentAdd(HttpServletRequest request, Comment comment) {
        comment.setCreateBy(getUserId(request));
        noteService.commentAdd(comment);
    }

}
