package com.ref.resources.note;

import com.github.pagehelper.PageInfo;
import com.ref.base.Resource.BaseResource;
import com.ref.base.constant.CommonConstant;
import com.ref.base.util.JsonUtil;
import com.ref.constant.PathConstants;
import com.ref.form.note.NoteForm;
import com.ref.model.note.Note;
import com.ref.service.note.NoteService;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Autowired
    NoteService noteService;

    @POST
    @Path(PathConstants.ROUTE_NOTE_ADD)
    public Response add(@BeanParam NoteForm noteForm, @CookieParam("token") String token) {
        noteForm.setCreateBy(getLoginUserId(token));
        noteService.addNoteAll(noteForm);
        return returnSuccess(CommonConstant.SUCCESS_JSON);
    }

    @GET
    @Path(PathConstants.ROUTE_NOTE_GET_PAGE)
    public Response getPage(Note note) {
        PageInfo pageInfo = noteService.getPage(note);
        return returnSuccess(JsonUtil.objectToJson(pageInfo));
    }
}
