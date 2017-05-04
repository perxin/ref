package com.ref.resources;

import com.alibaba.fastjson.JSONObject;
import com.ref.base.constant.CommonConstant.ErrorCode;
import com.ref.base.exception.BusinessException;
import com.ref.base.model.BaseResult;
import com.ref.base.util.RSAUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * Created by perxin on 2017/3/31.
 *
 */
public class BaseResource {

    private static Logger logger = LoggerFactory.getLogger(BaseResource.class);

    protected Long getLoginUserId(String token) {
        if (StringUtils.isEmpty(token)) {
            throw new BusinessException(ErrorCode.ERROR_CODE_NO_AUTHORIZATION);
        }
        String userId = RSAUtil.decryptByPrivateKey(token, RSAUtil.STR_PRIVATE_KEY);
        return userId == null ? null : Long.parseLong(userId);
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

    protected void setSession(HttpServletRequest request, String userName, Long userId) {
        request.getSession().setAttribute("name", userName);
        request.getSession().setAttribute("userId", userId);
    }

    protected void removeSession(HttpServletRequest request) {
        request.getSession().removeAttribute("name");
        request.getSession().removeAttribute("userId");
    }

    protected Long getUserId(HttpServletRequest request) throws BusinessException {
        Long userId = (Long) request.getSession().getAttribute("userId");
        if (userId == null) {
            throw new BusinessException(ErrorCode.ERROR_CODE_CUSTOM, "请先登录");
        } else {
            return userId;
        }
    }

    public BaseResult successResult(Object... message){
        BaseResult result = new BaseResult();
        result.setSuccess(true);
        result.setMessage(message);
        return result;
    }

    public BaseResult erroResult(Object message){
        BaseResult result = new BaseResult();
        result.setSuccess(false);
        result.setMessage(message);
        return result;
    }

}
