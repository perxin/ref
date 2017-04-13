package com.ref.resources.note;

import com.github.pagehelper.PageInfo;
import com.ref.base.Resource.BaseResource;
import com.ref.base.constant.CommonConstant;
import com.ref.base.util.JsonUtil;
import com.ref.constant.PathConstants;
import com.ref.form.note.NoteAllForm;
import com.ref.model.note.Comment;
import com.ref.service.note.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * Created by perxin on 2017/4/11.
 */
@Path(PathConstants.ROUTE_NOTE)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NoteResource extends BaseResource {

    private Logger log = LoggerFactory.getLogger(NoteResource.class);

    @Autowired
    private NoteService noteService;

    @POST
    @Path(PathConstants.ROUTE_NOTE_ADD)
    public Response add(@Valid NoteAllForm noteAllForm, @CookieParam("token") String token) {
        noteAllForm.setCreateBy(getLoginUserId(token));
        noteService.addNoteAll(noteAllForm);
        return returnSuccess(CommonConstant.SUCCESS_JSON);
    }

    @GET
    @Path(PathConstants.ROUTE_NOTE_GET_PAGE_HOT)
    public Response getPageHot(@QueryParam("pageNum") int pageNum, @QueryParam("pageSize") int pageSize) {
        PageInfo pageInfo = noteService.getPageHot(pageNum, pageSize);
        return returnSuccess(JsonUtil.objectToJson(pageInfo));
    }

    @GET
    @Path(PathConstants.ROUTE_NOTE_GET_PAGE_NEW)
    public Response getPageNew(@QueryParam("pageNum") int pageNum, @QueryParam("pageSize") int pageSize) {
        PageInfo pageInfo = noteService.getPageNew(pageNum, pageSize);
        return returnSuccess(JsonUtil.objectToJson(pageInfo));
    }

    @GET
    @Path(PathConstants.ROUTE_NOTE_GET_NOTE_DETAIL)
    public Response noteDetail(@PathParam(value = "noteId") String noteId) {
        NoteAllForm noteAllForm = noteService.getNoteDetail(noteId);
        return returnSuccess(JsonUtil.objectToJson(noteAllForm));
    }

    @POST
    @Path(PathConstants.ROUTE_NOTE_GET_COMMENT)
    public Response commentAdd(@Valid Comment comment, @CookieParam("token") String token) {
        comment.setCreateBy(getLoginUserId(token));
        noteService.commentAdd(comment);
        return returnSuccess(CommonConstant.SUCCESS_JSON);
    }

}
