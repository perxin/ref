package com.ref.base.exception;

import com.alibaba.fastjson.JSONObject;
import com.ref.base.constant.CommonConstant.ErrorCode;

public class BusinessException extends RuntimeException {
    static final long serialVersionUID = -7036897290745746979L;

    private ErrorCode errorCode;

    private String description;

    public BusinessException() {

    }

    public BusinessException(ErrorCode errorCode, String description) {
        super(description == null ? errorCode.getDescription() : description);
        this.errorCode = errorCode;
        this.description = description;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCode errorCode, Throwable e) {
        super(errorCode.getDescription(), e);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toJsonStr() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("errorCode", errorCode.getCode());
        jsonObject.put("description", description == null ? errorCode.getDescription() : description);
        return jsonObject.toString();
    }
}
