package com.ref.base.Resource;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * Created by perxin on 2017/3/31.
 *
 */
public class BaseResource {

    protected String getLoginUserId() {
        return null;
    }

    protected Response returnSuccess(String json) {
        if (json != null) {
            return Response.status(Status.OK).entity(json).type(MediaType.APPLICATION_JSON).build();
        } else {
            return Response.status(Status.OK).build();
        }
    }

    protected Response returnSuccess() {
        return Response.status(Status.OK).build();
    }
}
