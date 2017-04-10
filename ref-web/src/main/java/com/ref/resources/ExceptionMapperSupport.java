package com.ref.resources;

import com.ref.base.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * 统一异常处理器
 */
@Provider
public class ExceptionMapperSupport implements ExceptionMapper<Exception> {

    Logger logger = LoggerFactory.getLogger(ExceptionMapperSupport.class);

    @Override
    public Response toResponse(Exception exception) {
        if (exception instanceof BusinessException) {
            BusinessException businessException = (BusinessException) exception;
            logger.error(businessException.toJsonStr());
            return Response.ok(Response.Status.BAD_REQUEST).entity(businessException.toJsonStr()).build();
        }
        logger.error(exception.getMessage());
        return Response.ok(Response.Status.INTERNAL_SERVER_ERROR).entity(exception.getMessage()).build();
    }
}
