package com.ref.service.system;

import com.ref.base.Resource.BaseResource;
import com.ref.base.constant.CommonConstant;
import com.ref.constant.PathConstants;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;

@Path(PathConstants.ROUTE_FILE)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FileResource extends BaseResource {

    @Autowired
    FileService fileService;

    @POST
    @Path(PathConstants.ROUTE_FILE_UPLOAD)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response upload(@FormDataParam("file") InputStream file) {

        return returnSuccess(CommonConstant.SUCCESS_JSON);
    }

    @GET
    @Path(PathConstants.ROUTE_FILE_PAGE)
    public Response getPage(@QueryParam("relationId") Long relationId, @QueryParam("relationType") String relationType, @QueryParam("fileName") String fileName) {

        return null;
    }

}
