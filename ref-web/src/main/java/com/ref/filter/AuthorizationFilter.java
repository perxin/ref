package com.ref.filter;

import com.ref.base.constant.CommonConstant;
import com.ref.base.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import java.io.IOException;

public class AuthorizationFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        String token = containerRequestContext.getHeaderString("token");
        if (StringUtils.isEmpty(token)) {
            throw new BusinessException(CommonConstant.ErrorCode.ERROR_CODE_NO_AUTHORIZATION);
        }
    }
}
