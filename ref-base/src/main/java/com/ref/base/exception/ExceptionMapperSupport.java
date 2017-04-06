package com.ref.base.exception;

import com.ref.base.Resource.BaseResource;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionMapperSupport implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception e) {
        return BaseResource.returnError(e);
    }
}
