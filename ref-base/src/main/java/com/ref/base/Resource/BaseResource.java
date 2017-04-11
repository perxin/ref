package com.ref.base.Resource;

import com.alibaba.fastjson.JSONObject;
import com.ref.base.constant.CommonConstant.ErrorCode;
import com.ref.base.exception.BusinessException;
import com.ref.base.util.RSAUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * Created by perxin on 2017/3/31.
 *
 */
public class BaseResource {

    private static Logger logger = LoggerFactory.getLogger(BaseResource.class);

    protected String getLoginUserId(String token) {
        return RSAUtil.decryptByPrivateKey(token, RSAUtil.STR_PRIVATE_KEY);
    }

    public static Response returnError(Exception e) {
        if (e instanceof BusinessException) {
            BusinessException businessException = (BusinessException) e;
            ErrorCode errorCode = businessException.getErrorCode();
            if (StringUtils.isNotEmpty(errorCode.getDescription())) {
                JSONObject json = new JSONObject();
                JSONObject error = new JSONObject();
                error.put("code", errorCode.getCode());
                error.put("description", errorCode.getDescription());
                json.put("error", error);
                return returnError(json.toString());
            }
            return returnError(errorCode.toString());
        } else {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    private static Response returnError(String message) {
        return Response.status(Status.BAD_REQUEST).entity(message).type(MediaType.APPLICATION_JSON).build();
    }

    public static Response returnSuccess(String json) {
        if (json != null) {
            return Response.status(Status.OK).entity(json).type(MediaType.APPLICATION_JSON).build();
        } else {
            return Response.status(Status.OK).build();
        }
    }

    public static Response returnSuccess() {
        return Response.status(Status.OK).build();
    }

}
